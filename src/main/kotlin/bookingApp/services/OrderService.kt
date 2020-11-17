package bookingApp.services

import bookingApp.repositories.OrderRepository
import bookingApp.repositories.entity.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService {

    @Autowired
    private lateinit var orderRepository: OrderRepository

    fun getDataById(id: Int): Order? {
        return orderRepository.getById(id)
    }

    fun saveToDb(data: Order): Order {
        return orderRepository.save(data)
    }
}