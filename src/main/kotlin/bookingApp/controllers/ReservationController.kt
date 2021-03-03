package bookingApp.controllers

import bookingApp.controllers.convertors.ReservationConverter
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

    @Autowired
    private lateinit var reservationConverter: ReservationConverter

    @GetMapping("/users/{userId}/reservations/{reservationId}")
    fun getReservation(@PathVariable userId: Int, @PathVariable reservationId: Int): ReservationDto? = reservationConverter.convertToDto(reservationService.getDataById(reservationId)!!)

    @PostMapping(path = ["/users/{userId}/reserve"])
    fun addReservation(@PathVariable userId: Int, @RequestBody reservation: ReservationDto): ReservationDto = reservationConverter.convertToDto(reservationService.addReservation(reservation))

    @GetMapping("/users/{userId}/reservations/{reservationId}/cancel")
    fun cancelReservation(@PathVariable userId: Int, @PathVariable reservationId: Int) = reservationService.cancelReservation(reservationId)

    @GetMapping("/users/{userId}/reservations")
    fun getAllUserReservations(@PathVariable userId: Int): List<ReservationDto> = reservationConverter.convertAllToDto(reservationService.getAllReservationsByUserId(userId))
}

class ReservationDto(
        val reservationId: Int?,
        val userId: Int,
        val restaurantId: Int,
        val tableId: Int
)