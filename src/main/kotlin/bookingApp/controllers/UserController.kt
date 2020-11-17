package bookingApp.controllers

import bookingApp.repositories.entity.User
import bookingApp.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/users"])
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Int): User? {
        return userService.getById(userId)
    }

    @PostMapping(path = ["/register"])
    fun registerUser(@RequestBody user: UserDto): User {
        return userService.save(user)
    }

    @PostMapping(path = ["/login"])
    fun loginUser(@RequestBody userLogin: UserLoginDto): String {
        return "{ \"userExists\": \"${userService.isUserExist(userLogin)}\" }"
    }
}

data class UserDto(var login: String,
                   var password: String,
                   var fullname: String,
                   var telephone: String
)

data class UserLoginDto(val login: String, var password: String)