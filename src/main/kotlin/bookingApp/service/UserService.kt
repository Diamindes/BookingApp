package bookingApp.service

import bookingApp.repository.UserRepository
import bookingApp.repository.entity.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getDataById(id: Int): UserEntity? {
        return userRepository.getById(id)
    }

    fun saveToDb(data: UserEntity): UserEntity {
        return userRepository.save(data)
    }
}