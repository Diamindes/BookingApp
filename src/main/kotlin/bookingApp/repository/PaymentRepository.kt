package bookingApp.repository

import bookingApp.repository.entity.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<PaymentEntity, Int> {

    fun getById(id: Int): PaymentEntity?
}