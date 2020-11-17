package bookingApp.service

import bookingApp.repository.OrderTypeRepository
import bookingApp.repository.entity.OrderTypeEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderTypeService {

    @Autowired
    private lateinit var orderTypeRepository: OrderTypeRepository

    fun getDataById(id: Int): OrderTypeEntity? {
        return orderTypeRepository.getById(id)
    }

    fun saveToDb(data: OrderTypeEntity): OrderTypeEntity {
        return orderTypeRepository.save(data)
    }
}