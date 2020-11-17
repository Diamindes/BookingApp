package bookingApp.service

import bookingApp.repository.PaymentTypeRepository
import bookingApp.repository.entity.PaymentTypeEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentTypeService {

    @Autowired
    private lateinit var paymentTypeRepository: PaymentTypeRepository

    fun getDataById(id: Int): PaymentTypeEntity? {
        return paymentTypeRepository.getById(id)
    }

    fun saveToDb(data: PaymentTypeEntity): PaymentTypeEntity {
        return paymentTypeRepository.save(data)
    }
}