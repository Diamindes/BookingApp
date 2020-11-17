package bookingApp.repository

import bookingApp.repository.entity.ReservationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<ReservationEntity, Int> {

    fun getById(id: Int): ReservationEntity?
}