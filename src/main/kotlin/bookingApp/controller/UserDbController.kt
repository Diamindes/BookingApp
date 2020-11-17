package bookingApp.controller

import bookingApp.repository.entity.User
import bookingApp.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/db"])
class UserDbController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/userGet/{id}")
    fun getFromDb(@PathVariable id: Int): User? {
        return userService.getDataById(id)
    }

    @PostMapping(path = ["/registerPost"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun saveToDb(@RequestBody data: User): User {
        return userService.saveToDb(data)
    }
}