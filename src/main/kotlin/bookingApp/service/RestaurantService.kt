package bookingApp.service

import bookingApp.repository.RestaurantRepository
import bookingApp.repository.entity.RestaurantEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestaurantService {

    @Autowired
    private lateinit var restaurantRepository: RestaurantRepository

    fun getDataById(id: Int): RestaurantEntity? {
        return restaurantRepository.getById(id)
    }

    fun saveToDb(data: RestaurantEntity): RestaurantEntity {
        return restaurantRepository.save(data)
    }
}