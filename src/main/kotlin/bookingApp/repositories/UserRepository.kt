package bookingApp.repositories

import bookingApp.repositories.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int> {

    fun getByLogin(login: String): User
    fun getById(id: Int): User
    fun getByRestaurantId(restaurantId: Int): List<User>
    fun existsByLogin(userLogin: String): Boolean
}