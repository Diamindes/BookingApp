package bookingApp.controllers

import bookingApp.repositories.entity.Restaurant
import bookingApp.services.RestaurantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/restaurants"])
class RestaurantController {

    @Autowired
    private lateinit var restaurantService: RestaurantService

    @GetMapping("")
    fun getRestaurantsList(): List<Restaurant> {
        return restaurantService.getAllRestaurants()
    }

    @GetMapping(path = ["/{restaurantId}"])
    fun getRestaurantById(@PathVariable restaurantId: Int) = restaurantService.getDataById(restaurantId)
}