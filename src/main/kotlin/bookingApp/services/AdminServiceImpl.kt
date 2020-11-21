package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.User
import bookingApp.services.api.AdminService
import org.springframework.beans.factory.annotation.Autowired

class AdminServiceImpl : UserServiceImpl(), AdminService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun registerEmployee(user: UserDto): User {
        return register(data = user)
    }

    override fun deleteEmployee(userId: Int): String {
        userRepository.deleteById(userId)
        return "Waiter deleted"
    }

    override fun getEmployees(restaurantId: Int): List<User> {
        return userRepository.findAll().filter { it.restaurant?.id ?: -1 >= 0 }
    }

    override fun associateWaiterWithTable(userId: Int, tableId: Int): Boolean {
        return true
    }

}