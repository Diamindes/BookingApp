package bookingApp.controllers

import bookingApp.repositories.entity.User
import bookingApp.services.AdminServiceImpl
import bookingApp.services.api.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/{adminId}"])
class AdminController {

    @Autowired
    private lateinit var adminService: AdminServiceImpl

    @PostMapping(path = ["/registerEmployee"])
    fun registerEmployee(@RequestBody user: UserDto): User = adminService.registerEmployee(user)

    @PostMapping(path = ["/deleteEmployee"])
    fun deleteEmployee(@RequestBody userId: Int): String = adminService.deleteEmployee(userId)

    @GetMapping("/employees")
    fun getEmployeesByRestaurant(restaurantId: Int) = adminService.getEmployees(restaurantId)
}