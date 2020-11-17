package bookingApp.repository

import bookingApp.repository.entity.OrderEntity
import bookingApp.repository.entity.PaymentTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentTypeRepository : JpaRepository<PaymentTypeEntity, Int> {

    fun getById(id: Int): PaymentTypeEntity?
}