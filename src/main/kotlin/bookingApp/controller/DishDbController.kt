package bookingApp.controller

import bookingApp.repository.entity.DishEntity
import bookingApp.service.DishService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/db"])
class DishDbController {

    @Autowired
    private lateinit var dishService: DishService

    @GetMapping("/dishGet/{id}")
    fun getFromDb(@PathVariable id: Int): DishEntity? {
        return dishService.getDataById(id)
    }

    @PostMapping(path = ["/dishPost"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveToDb(@RequestBody data: DishEntity): DishEntity {
        return dishService.saveToDb(data)
    }
}