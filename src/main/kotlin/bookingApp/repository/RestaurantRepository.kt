package bookingApp.repository

import bookingApp.repository.entity.RestaurantEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository : JpaRepository<RestaurantEntity, Int> {

    fun getById(id: Int): RestaurantEntity?
}