package bookingApp.repositories

import bookingApp.repositories.entity.Restaurant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository : JpaRepository<Restaurant, Int> {

    fun getById(id: Int): Restaurant?
}