package bookingApp.controllers

import bookingApp.repositories.entity.Menu
import bookingApp.services.MenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/restaurants/{restaurantId}"])
class MenuController {

    @Autowired
    private lateinit var menuService: MenuService

    @GetMapping("/menu")
    fun getMenuById(@PathVariable restaurantId: Int): Menu? =
            menuService.getMenuByRestaurant(restaurantId)

    @GetMapping(path = ["/menu/dishes"])
    fun getDishes(@PathVariable restaurantId: Int) =
            menuService.getDishes(restaurantId)

}