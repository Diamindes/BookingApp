package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.User
import bookingApp.services.api.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
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

    override fun associateWaiterWithTable(employeeId: Int, tableId: Int): Boolean {
        return TableService().setEmployee(employeeId, tableId)
    }

    override fun getAssociationsWithTable(restaurantId: Int): List<Pair<Int, Int>> =
            RestaurantService().getDataById(restaurantId)?.tables?.map { it -> Pair(it.numberName, it.employeeId) }
                    ?: emptyList()
}