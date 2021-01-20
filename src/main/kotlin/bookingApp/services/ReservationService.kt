package bookingApp.services

import bookingApp.controllers.ReservationDto
import bookingApp.repositories.ReservationRepository
import bookingApp.repositories.RestaurantRepository
import bookingApp.repositories.TableRepository
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.Reservation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ReservationService {

    @Autowired
    private lateinit var reservationRepository: ReservationRepository

    @Autowired
    private lateinit var tableRepository: TableRepository

    @Autowired
    private lateinit var restaurantRepository: RestaurantRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getDataById(id: Int): Reservation? {
        return reservationRepository.getById(id)
    }

    fun addReservation(data: ReservationDto): ReservationDto {
        return convertToDto(
                reservationRepository.save(
                    Reservation(
                            user = userRepository.getById(data.userId),
                            restaurant = restaurantRepository.getById(data.restaurantId),
                            table = tableRepository.getById(data.tableId)
                    )
                )
        )
    }

    fun cancelReservation(id: Int) {
        reservationRepository.deleteById(id)
    }

    fun getAllReservationsByUserId(userId: Int): List<ReservationDto> {
        return reservationRepository.getByUser(userRepository.getById(userId)).stream()
                .map(this::convertToDto)
                .toList()
    }

    fun convertToDto(reservation:Reservation): ReservationDto {
        return ReservationDto(
                reservationId = reservation.id,
                userId = reservation.user.id!!,
                restaurantId = reservation.restaurant.id!!,
                tableId = reservation.table!!.id!!
        )
    }
}