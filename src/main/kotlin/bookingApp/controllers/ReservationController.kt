package bookingApp.controllers

import bookingApp.repositories.entity.Reservation
import bookingApp.services.ReservationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ReservationController {

    @Autowired
    private lateinit var reservationService: ReservationService

    @GetMapping("/users/{userId}/reservations/{reservationId}")
    fun getReservation(@PathVariable userId: Int, @PathVariable reservationId: Int): Reservation? = reservationService.getDataById(reservationId)

    @PostMapping(path = ["/users/{userId}/reserve"])
    fun addReservation(@PathVariable userId: Int, @RequestBody reservation: ReservationDto): ReservationDto = reservationService.addReservation(reservation)

    @GetMapping("/users/{userId}/reservations/{reservationId}/cancel")
    fun cancelReservation(@PathVariable userId: Int, @PathVariable reservationId: Int) = reservationService.cancelReservation(reservationId)

    @GetMapping("/users/{userId}/reservations")
    fun getAllUserReservations(@PathVariable userId: Int): List<ReservationDto> = reservationService.getAllReservationsByUserId(userId)
}

class ReservationDto(
        val reservationId: Int?,
        val userId: Int,
        val restaurantId: Int,
        val tableId: Int
)