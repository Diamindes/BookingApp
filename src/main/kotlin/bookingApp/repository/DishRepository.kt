package bookingApp.repository

import bookingApp.repository.entity.DishEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DishRepository : JpaRepository<DishEntity, Int> {

    fun getById(id: Int): DishEntity?
}