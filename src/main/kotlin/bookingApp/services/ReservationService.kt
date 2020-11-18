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
}