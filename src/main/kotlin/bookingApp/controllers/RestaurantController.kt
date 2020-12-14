package bookingApp.controllers

import bookingApp.repositories.entity.Restaurant
import bookingApp.services.RestaurantService
import bookingApp.services.utils.PageRequestHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/restaurants"])
class RestaurantController {

    @Autowired
    private lateinit var restaurantService: RestaurantService

    @GetMapping
    fun getRestaurantsList(): MutableIterable<Restaurant> {
        return restaurantService.getAllRestaurants()
    }

    @GetMapping("/filter")
    fun getRestaurantsByFilter(
            @RequestParam(name = "page", defaultValue = "0", required = false) page: Int,
            @RequestParam(name = "size", defaultValue = "10", required = false) size: Int,
            @RequestParam(name = "sort", required = false) sortJson: String?,
            @RequestParam(name = "filter", required = false) filtersJson: String?
    ): Page<Restaurant>? {
        return restaurantService.getByCriteria(PageRequestHolder(sortJson, page, size, filtersJson))
    }

    @GetMapping(path = ["/{restaurantId}"])
    fun getRestaurantById(@PathVariable restaurantId: Int) = restaurantService.getById(restaurantId)
}