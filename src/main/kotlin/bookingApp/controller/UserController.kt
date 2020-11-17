package bookingApp.controller

import bookingApp.repository.entity.*
import bookingApp.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/userGet")
    fun getData(index: Int): User? {
        return userService.getDataById(index)
    }

    @PostMapping(path = ["/registerUser"])
    fun registerUser(@RequestBody input: UserDto): String {
        return "Register user with login -  ${input.login}"
    }

    @PostMapping(path = ["/login"])
    fun loginUser(@RequestBody input: UserLoginDto): Boolean {
        return userService.isUserExist(input)
    }
}

data class UserDto(var login: String,
                   var password: String,
                   var fullname: String,
                   var telephone: String,
                   var roleType: RoleType,
                   val restaurant: Restaurant,
                   val reservations: MutableList<Reservation>,
                   val orders: MutableList<Order>,
                   val favoriteDishes: MutableList<Dish> = mutableListOf()
)

data class UserLoginDto(val login: String,
                        var password: String,
                        var telephone: String
)