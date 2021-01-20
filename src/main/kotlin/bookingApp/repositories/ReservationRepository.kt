package bookingApp.repositories

import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<Reservation, Int> {

    fun getById(id: Int): Reservation?
    fun getByUser(user: User?): List<Reservation>
}