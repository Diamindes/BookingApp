package bookingApp.services

import bookingApp.repositories.RestaurantRepository
import bookingApp.repositories.entity.Restaurant
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

    fun getAllRestaurants(): List<Restaurant> {
        return restaurantRepository.findAll()
    }
}