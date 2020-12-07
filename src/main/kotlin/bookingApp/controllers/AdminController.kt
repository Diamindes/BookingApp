package bookingApp.controllers

import bookingApp.repositories.entity.User
import bookingApp.services.api.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/admins/{adminId}"])
class AdminController {

    @Autowired
    private lateinit var adminService: UserService

    @PostMapping(path = ["/registerEmployee"])
    fun registerEmployee(@RequestBody user: UserDto): User = adminService.registerEmployee(user)

    @PostMapping(path = ["/deleteEmployee"])
    fun deleteEmployee(@RequestBody userId: Int): String = adminService.deleteEmployee(userId)

    @GetMapping("/employees")
    fun getEmployeesByRestaurant(restaurantId: Int) = adminService.getEmployees(restaurantId)
}