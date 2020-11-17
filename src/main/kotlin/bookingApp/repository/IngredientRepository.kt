package bookingApp.repository

import bookingApp.repository.entity.IngredientEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IngredientRepository : JpaRepository<IngredientEntity, Int> {

    fun getById(id: Int): IngredientEntity?
}