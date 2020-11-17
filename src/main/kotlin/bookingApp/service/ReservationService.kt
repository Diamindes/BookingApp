package bookingApp.service

import bookingApp.repository.ReservationRepository
import bookingApp.repository.entity.Reservation
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