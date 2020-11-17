package bookingApp.repository

import bookingApp.controller.UserLoginDto
import bookingApp.repository.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {

    fun getById(id: Int): User?
    fun isUserExist(user: UserLoginDto): Boolean
}