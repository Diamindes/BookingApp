package bookingApp.controllers

import bookingApp.repositories.entity.Order
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.Restaurant
import bookingApp.repositories.entity.TableEntity
import bookingApp.repositories.entity.User
import bookingApp.services.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Date

@RestController
@RequestMapping(path = [""])
class ReservationController {

    @Autowired
    private lateinit var reservationService: ReservationService

    @GetMapping("/users/{userId}/reservations/{reservationId}")
    fun getReservation(@PathVariable userId: Int, @PathVariable reservationId: Int): Reservation? {
        return reservationService.getDataById(reservationId)
    }

    @PostMapping(path = ["/users/{userId}/reserve"])
    fun addReservation(@PathVariable userId: Int, @RequestBody reservation: ReservationDto): Reservation {
        return reservationService.saveToDb(reservation)
    }

    @GetMapping("/users/{userId}/reservations")
    fun getReservationsByUser(@PathVariable userId: Int): List<Reservation> = reservationService.getReservationsByUser(userId)

    @GetMapping("/admins/{adminId}/reservations")
    fun getReservationsByAdmin(@PathVariable adminId: Int): List<Reservation> = reservationService.getReservationsByAdmin(adminId)

//    @GetMapping("/waiters/{waiterId}/reservations")
//    fun getReservationsByWaiter(@PathVariable waiterId: Int): List<Reservation> = reservationService.getReservationsByWaiter(waiterId)
}

class ReservationDto(
        val user: User,
        val restaurant: Restaurant,
        val table: TableEntity,
        val order: Order,
        val dateStartReservation: Date,
        val dateEndReservation: Date,
        val dateCreateReservation: Date
)