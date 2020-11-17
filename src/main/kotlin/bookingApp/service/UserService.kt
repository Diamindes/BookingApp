package bookingApp.service

import bookingApp.controller.UserLoginDto
import bookingApp.repository.UserRepository
import bookingApp.repository.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getDataById(id: Int): User? {
        return userRepository.getById(id)
    }

    fun saveToDb(data: User): User {
        return userRepository.save(data)
    }

    fun isUserExist(user: UserLoginDto): Boolean {
        return userRepository.isUserExist(user)
    }
}