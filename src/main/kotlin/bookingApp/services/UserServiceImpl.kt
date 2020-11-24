package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.User
import bookingApp.services.api.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getById(id: Int): User? {
        return userRepository.getById(id)
    }

    override fun register(data: UserDto): User {
        return userRepository.save(
                User(
                        login = data.login,
                        password = data.password,
                        fullname = data.fullname,
                        telephone = data.telephone,
                        roleType = data.role
                )
        )
    }

    override fun login(user: UserLoginDto): Boolean {
        return userRepository.existsByLogin(user.login)
    }

    override fun getReservations(id: Int): List<Reservation> {
        return getById(id)?.reservations ?: emptyList()
    }

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