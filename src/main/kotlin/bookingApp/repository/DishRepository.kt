package bookingApp.repository

import bookingApp.repository.entity.Dish
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DishRepository : JpaRepository<Dish, Int> {

    fun getById(id: Int): Dish?
}