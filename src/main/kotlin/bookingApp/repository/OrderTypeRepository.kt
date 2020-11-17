package bookingApp.repository

import bookingApp.repository.entity.OrderTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderTypeRepository : JpaRepository<OrderTypeEntity, Int> {

    fun getById(id: Int): OrderTypeEntity?
}