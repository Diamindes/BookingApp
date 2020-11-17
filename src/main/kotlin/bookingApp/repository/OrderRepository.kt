package bookingApp.repository

import bookingApp.repository.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Int> {

    fun getById(id: Int): Order?
}