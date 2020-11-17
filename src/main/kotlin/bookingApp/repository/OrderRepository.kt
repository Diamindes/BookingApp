package bookingApp.repository

import bookingApp.repository.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<OrderEntity, Int> {

    fun getById(id: Int): OrderEntity?
}