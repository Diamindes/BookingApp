package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.RoleType
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
                        roleType = RoleType.USER
                )
        )
    }

    override fun login(user: UserLoginDto): Boolean {
        return userRepository.existsByLogin(user.login)
    }

    override fun getReservations(id: Int): List<Reservation> {
        return getById(id)?.reservations ?: emptyList()
    }
}