package bookingApp.service

import bookingApp.repository.OrderRepository
import bookingApp.repository.entity.OrderEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService {

    @Autowired
    private lateinit var orderRepository: OrderRepository

    fun getDataById(id: Int): OrderEntity? {
        return orderRepository.getById(id)
    }

    fun saveToDb(data: OrderEntity): OrderEntity {
        return orderRepository.save(data)
    }
}