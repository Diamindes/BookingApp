package bookingApp.controllers

import bookingApp.repositories.entity.*
import bookingApp.services.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.Date

@RestController
@RequestMapping(path = ["/users/{userId}/reservations"])
class ReservationController {

    @Autowired
    private lateinit var reservationService: ReservationService

    @GetMapping("/{reservationId}")
    fun getReservation(@PathVariable userId: Int, @PathVariable reservationId: Int): Reservation? {
        return reservationService.getDataById(reservationId)
    }

    @PostMapping(path = ["/newReservation"])
    fun addReservation(@PathVariable userId: Int, @RequestBody reservation: ReservationDto): Reservation {
        return reservationService.saveToDb(reservation)
    }
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