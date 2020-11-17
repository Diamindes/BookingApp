package bookingApp.services

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

    fun saveToDb(data: Reservation): Reservation {
        return reservationRepository.save(data)
    }
}