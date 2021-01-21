package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import bookingApp.services.api.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var restaurantService: RestaurantService

    override fun getById(id: Int): User {
        return userRepository.getById(id)
    }

    override fun getByLogin(login: String): UserDto? {
        val profile = userRepository.getByLogin(login)
        return UserDto(
            id = profile.id,
            login = profile.login,
            password = profile.password,
            fullname = profile.fullname,
            telephone = profile.telephone,
            role = profile.roleType,
        )
    }

    override fun register(user: User): User {
        return userRepository.save(user)
    }

    override fun register(user: UserDto): User {
        return register(
                User(
                        login = user.login,
                        password = BCryptPasswordEncoder().encode(user.password),
                        fullname = user.fullname,
                        telephone = user.telephone,
                        roleType = user.role
                )
        )
    }

    override fun registerEmployee(user: UserDto, restaurantId: Int): User {
        return register(
                User(
                        login = user.login,
                        password = BCryptPasswordEncoder().encode(user.password),
                        fullname = user.fullname,
                        telephone = user.telephone,
                        roleType = RoleType.WAITER,
                        restaurant = restaurantService.getById(restaurantId)
                )
        )
    }

    override fun getAll(restaurantId: Int): List<User> {
        return userRepository.getByRestaurantId(restaurantId)
    }

    override fun deleteEmployee(userId: Int, restaurantId: Int) {
        val user = userRepository.getById(userId)
        if (user.roleType == RoleType.WAITER && user.restaurant?.id == restaurantId){
            userRepository.deleteById(userId)
        }
    }

    override fun getReservations(id: Int): List<Reservation> {
        return getById(id).reservations
    }

    override fun login(user: UserLoginDto): Boolean {
        return userRepository.existsByLogin(user.login)
    }
}