package bookingApp.services

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getById(id: Int): User? {
        return userRepository.getById(id)
    }

    fun save(data: UserDto): User {
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

    fun isUserExist(user: UserLoginDto): Boolean {
        return userRepository.existsByLogin(user.login)
    }
}