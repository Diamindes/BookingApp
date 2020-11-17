package bookingApp.controller

import bookingApp.repository.entity.DishEntity
import bookingApp.repository.entity.IngredientEntity
import bookingApp.service.DishService
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
    fun getData(index: Int): DishEntity? {
        return dishService.getDataById(index)
    }

    @PostMapping(path = ["/dishPost"])
    fun postData(@RequestBody input: dishDto): String {
        return "Received data -  ${input.name} and ${input.ingredientsList}"
    }
}

data class dishDto(val name: String,
                   val ingredientsList: MutableList<IngredientEntity>)