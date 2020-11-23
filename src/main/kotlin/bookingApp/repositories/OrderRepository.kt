package bookingApp.repositories

import bookingApp.repositories.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Int> {

    fun getById(id: Int): Order?
}