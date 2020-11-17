package bookingApp.service

import bookingApp.repository.ReservationRepository
import bookingApp.repository.entity.ReservationEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReservationService {

    @Autowired
    private lateinit var reservationRepository: ReservationRepository

    fun getDataById(id: Int): ReservationEntity? {
        return reservationRepository.getById(id)
    }

    fun saveToDb(data: ReservationEntity): ReservationEntity {
        return reservationRepository.save(data)
    }
}