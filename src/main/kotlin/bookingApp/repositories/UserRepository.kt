package bookingApp.repositories

import bookingApp.repositories.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int> {

    fun getById(id: Int): User?
    fun existsByLogin(userLogin: String): Boolean
    fun getByTelephone(tel: String) : User?
}