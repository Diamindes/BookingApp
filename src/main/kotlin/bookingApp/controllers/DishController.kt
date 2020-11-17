package bookingApp.controllers

import bookingApp.repositories.entity.Dish
import bookingApp.repositories.entity.Ingredient
import bookingApp.services.DishService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class DishController {

    @Autowired
    private lateinit var dishService: DishService

    @GetMapping("/dishGet")
    fun getData(index: Int): Dish? {
        return dishService.getDataById(index)
    }

    @PostMapping(path = ["/dishPost"])
    fun postData(@RequestBody input: dishDto): String {
        return "Received data -  ${input.name} and ${input.ingredientsList}"
    }
}

data class dishDto(val name: String,
                   val ingredientsList: MutableList<Ingredient>)