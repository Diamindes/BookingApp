package bookingApp.controllers

import bookingApp.repositories.entity.Dish
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

    @GetMapping("/dishGet/{id}")
    fun getFromDb(@PathVariable id: Int): Dish? {
        return dishService.getDataById(id)
    }

    @PostMapping(path = ["/dishPost"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveToDb(@RequestBody data: Dish): Dish {
        return dishService.saveToDb(data)
    }
}