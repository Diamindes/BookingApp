package bookingApp.camunda_delegates

import bookingApp.controllers.ReservationDto
import bookingApp.services.*
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.util.*


@Component
class PerformReservationDelegate : JavaDelegate {

    @Autowired
    var reservationService: ReservationService? = null

    @Autowired
    var userService: UserServiceImpl? = null

    @Autowired
    var restaurantService: RestaurantService? = null

    @Autowired
    var tableService: TableService? = null

    @Autowired
    var orderService: OrderService? = null
    @Throws(Exception::class)
    override fun execute(execution: DelegateExecution) {
        var isReserved = true
        var message = ""
        try {

            //check if user exists by phone
            val user = userService!!.getByPhone((execution.getVariable("user_phone") as String))
            if (user == null) {
                message = "There is no User with such a phone number!"
                throw Exception()
            }
            //Check if such a restaurant exists by name
            val restaurant = restaurantService!!.getByName((execution.getVariable("restaurant_name") as String))
            if (restaurant == null) {
                message = "No such restaurant!"
                throw Exception()
            }
            //Check if there is any table with such number of seats
            val table = tableService!!.getByNumberOfSeats((execution.getVariable("num_of_seat") as String).toInt())
            if (table == null) {
                message = "No free tables with such a number of seats!"
                throw Exception()
            }

            //Perform reservation
            val order = orderService!!.getDataById(1)
            if (order != null) {
                val reservStart = Timestamp((execution.getVariable("reservation_date") as Date).time)
                reservationService!!.saveToDb(ReservationDto(
                        user,
                        restaurant,
                        table,
                        order,
                        reservStart,
                        reservStart,
                        Timestamp(System.currentTimeMillis())))
            } else {
                message = "You need to place the order first for the reservation!"
                throw Exception()
            }
        } catch (e: Exception) {
            isReserved = false
            if (message == "") {
                println(e.printStackTrace())
            }
            execution.setVariable("message", message)
        }
        execution.setVariable("reserved", isReserved)
    }
}