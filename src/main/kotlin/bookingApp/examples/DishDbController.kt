package bookingApp.examples

import bookingApp.repositories.entity.Dish
import bookingApp.repositories.entity.Ingredient
import bookingApp.services.DishService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/db"])
class DishDbController {

    @Autowired
    private lateinit var dishService: DishService

    @GetMapping("/dishDbGet/{id}")
    fun getFromDb(@PathVariable id: Int): Dish? {
        return dishService.getDataById(id)
    }

    @PostMapping(path = ["/dishDbPost"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveToDb(@RequestBody data: Dish): Dish {
        return dishService.saveToDb(data)
    }

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