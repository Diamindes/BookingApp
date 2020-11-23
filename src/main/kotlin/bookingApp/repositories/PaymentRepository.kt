package bookingApp.repositories

import bookingApp.repositories.entity.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<Payment, Int> {

    fun getById(id: Int): Payment?
}