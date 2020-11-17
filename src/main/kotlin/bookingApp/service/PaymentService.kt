package bookingApp.service

import bookingApp.repository.PaymentRepository
import bookingApp.repository.entity.Payment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService {

    @Autowired
    private lateinit var paymentRepository: PaymentRepository

    fun getDataById(id: Int): Payment? {
        return paymentRepository.getById(id)
    }

    fun saveToDb(data: Payment): Payment {
        return paymentRepository.save(data)
    }
}