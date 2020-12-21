package bookingApp.services

import bookingApp.controllers.ReservationDto
import bookingApp.repositories.ReservationRepository
import bookingApp.repositories.entity.Reservation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReservationService {

    @Autowired
    private lateinit var reservationRepository: ReservationRepository

    fun getDataById(id: Int): Reservation? {
        return reservationRepository.getById(id)
    }

    fun saveToDb(data: ReservationDto): Reservation {
        return reservationRepository.save(
                Reservation(
                        user = data.user,
                        restaurant = data.restaurant,
                        table = data.table,
                        order = data.order,
                        dateCreateReservation = data.dateCreateReservation,
                        dateStartReservation = data.dateStartReservation,
                        dateEndReservation = data.dateEndReservation
                )
        )
    }

    fun getReservationsByUser(userId: Int): List<Reservation> {
        return reservationRepository.findAll().filter { it.user.id == userId }
    }

    fun getReservationsByAdmin(adminId: Int): List<Reservation> {
        val restaurantId: Int = UserServiceImpl().getById(adminId)?.restaurant?.id ?: return emptyList()
        return reservationRepository.findAll().filter { it.restaurant.id == restaurantId }
    }

    fun getReservationsByWaiter(waiterId: Int): List<Reservation> {
        val restaurantId: Int = UserServiceImpl().getById(waiterId)?.restaurant?.id ?: return emptyList()
        return reservationRepository.findAll().filter { it.restaurant.id == restaurantId }.filter { it.table?.employeeId == waiterId }
    }
}