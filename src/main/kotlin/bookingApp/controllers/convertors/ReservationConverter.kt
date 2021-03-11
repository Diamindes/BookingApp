package bookingApp.controllers.convertors

import bookingApp.controllers.ReservationDto
import bookingApp.repositories.entity.Reservation
import org.springframework.stereotype.Component

@Component
class ReservationConverter {

    fun convertToDto(reservation: Reservation): ReservationDto {
        return ReservationDto(
                reservationId = reservation.id,
                userId = reservation.user.id!!,
                restaurantId = reservation.restaurant.id!!,
                tableId = reservation.table!!.id!!,
                reservationStartTime = reservation.reservationStartTime,
                reservationEndTime = reservation.reservationEndTime
        )
    }

    fun convertAllToDto(reservations: List<Reservation>): List<ReservationDto> {
        return reservations.map(this::convertToDto).toList()
    }
}