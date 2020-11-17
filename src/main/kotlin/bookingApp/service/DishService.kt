package bookingApp.service

import bookingApp.repository.DishRepository
import bookingApp.repository.entity.DishEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DishService {

    @Autowired
    private lateinit var dishRepository: DishRepository

    fun getDataById(id: Int): DishEntity? {
        return dishRepository.getById(id)
    }

    fun saveToDb(dishData: DishEntity): DishEntity {
        return dishRepository.save(dishData)
    }
}