package bookingApp.services

import bookingApp.repositories.MenuRepository
import bookingApp.repositories.entity.Dish
import bookingApp.repositories.entity.Menu
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuService {

    @Autowired
    private lateinit var menuRepository: MenuRepository

    fun getMenuByRestaurant(restaurantId: Int): Menu? {
        return RestaurantService().getById(restaurantId).menu
    }

    fun saveToDb(data: Menu): Menu {
        return menuRepository.save(data)
    }

    fun getDishes(restaurantId: Int): List<Dish> =
            getMenuByRestaurant(restaurantId)?.dishesList ?: emptyList()

}