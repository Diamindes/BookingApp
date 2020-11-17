package bookingApp.service

import bookingApp.repository.RestaurantRepository
import bookingApp.repository.entity.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RestaurantService {

    @Autowired
    private lateinit var restaurantRepository: RestaurantRepository

    fun getDataById(id: Int): Restaurant? {
        return restaurantRepository.getById(id)
    }

    fun saveToDb(data: Restaurant): Restaurant {
        return restaurantRepository.save(data)
    }
}