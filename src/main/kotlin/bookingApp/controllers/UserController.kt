package bookingApp.controllers

import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import bookingApp.services.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/users"])
class UserController {

    @Qualifier("user_service")
    @Autowired
    private lateinit var userService: UserServiceImpl

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Int): User? = userService.getById(userId)

    @PostMapping(path = ["/register"])
    fun registerUser(@RequestBody user: UserDto): User = userService.register(user)


    @PostMapping(path = ["/login"])
    fun loginUser(@RequestBody userLogin: UserLoginDto): String {
        return "{ \"userExists\": \"${userService.login(userLogin)}\" }"
    }
}

data class UserDto(var id: Int,
                   var login: String,
                   var password: String,
                   var fullname: String,
                   var telephone: String,
                   var role: RoleType) {

    companion object {
    }
}

data class UserLoginDto(val login: String, var password: String)