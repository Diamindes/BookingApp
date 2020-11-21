package bookingApp.controllers

import bookingApp.repositories.entity.User
import bookingApp.services.api.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/{adminId}"])
class AdminController {

    @Autowired
    private lateinit var adminService: AdminService

    @PostMapping(path = ["/registerEmployee"])
    fun registerEmployee(@RequestBody user: UserDto): User = adminService.registerEmployee(user)

    @PostMapping(path = ["/deleteEmployee"])
    fun deleteEmployee(@RequestBody user: User): String = adminService.deleteEmployee(user = user)


}