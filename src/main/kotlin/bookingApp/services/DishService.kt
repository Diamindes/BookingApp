package bookingApp.services

import bookingApp.repositories.DishRepository
import bookingApp.repositories.entity.Dish
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DishService {

    @Autowired
    private lateinit var dishRepository: DishRepository

    fun getDataById(id: Int): Dish? {
        return dishRepository.getById(id)
    }

    fun saveToDb(dishData: Dish): Dish {
        return dishRepository.save(dishData)
    }
}