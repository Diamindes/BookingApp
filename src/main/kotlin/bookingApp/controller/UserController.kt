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
    fun postData(@RequestBody input: UserDto): String {
        return "Received user data -  ${input.login}"
    }
}

data class UserDto(var login: String? = "",
                   var password: String? = "",
                   var fullname: String = "",
                   var telephone: String? = "",
                   var roleType: RoleType = RoleType.USER,
                   var restaurant: Restaurant? = null,
                   val reservations: MutableList<Reservation> = mutableListOf(),
                   val orders: MutableList<Order> = mutableListOf(),
                   val favoriteDishes: MutableList<Dish> = mutableListOf()
)