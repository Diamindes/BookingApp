package bookingApp.controllers

import bookingApp.controllers.convertors.UserConverter
import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import bookingApp.services.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping(path = ["/users"])
class UserController {

    @Autowired
    private lateinit var userService: UserServiceImpl

    @Autowired
    private lateinit var userConverter: UserConverter

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Int): UserDto? = userConverter.convertToDto(userService.getById(userId))

    @PostMapping(path = ["/register"])
    fun registerUser(@RequestBody user: UserDto): User = userService.register(user)

    @GetMapping("/profile")
    fun getProfile(principal: Principal): UserDto? = userConverter.convertToDto(userService.getByLogin(principal.name))
}

data class UserDto(var id: Int?,
                   var login: String,
                   var password: String,
                   var fullname: String?,
                   var telephone: String?,
                   var role: RoleType,
                   var restaurantId: Int?) {
    companion object
}

data class UserLoginDto(val login: String, var password: String?)