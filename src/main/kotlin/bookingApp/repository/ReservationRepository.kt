package bookingApp.repository

import bookingApp.repository.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<Reservation, Int> {

    fun getById(id: Int): Reservation?
}