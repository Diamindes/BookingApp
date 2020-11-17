package bookingApp.service

import bookingApp.repository.PaymentRepository
import bookingApp.repository.entity.PaymentEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService {

    @Autowired
    private lateinit var paymentRepository: PaymentRepository

    fun getDataById(id: Int): PaymentEntity? {
        return paymentRepository.getById(id)
    }

    fun saveToDb(data: PaymentEntity): PaymentEntity {
        return paymentRepository.save(data)
    }
}