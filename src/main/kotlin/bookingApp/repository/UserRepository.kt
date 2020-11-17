package bookingApp.repository

import bookingApp.repository.entity.OrderEntity
import bookingApp.repository.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Int> {

    fun getById(id: Int): UserEntity?
}