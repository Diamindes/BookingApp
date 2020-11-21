package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.User
import bookingApp.services.api.AdminService
import org.springframework.beans.factory.annotation.Autowired

class AdminServiceImpl : UserServiceImpl(), AdminService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun registerEmployee(data: UserDto): User {
        return register(data = data)
    }

    override fun deleteEmployee(user: User): String {
        userRepository.delete(user)
        return "Waiter deleted"
    }

    override fun associateWaiterWithTable(userId: Int, tableId: Int): Boolean {
        return true
    }

}