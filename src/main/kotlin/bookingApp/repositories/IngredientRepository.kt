package bookingApp.repositories

import bookingApp.repositories.entity.Ingredient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IngredientRepository : JpaRepository<Ingredient, Int> {

    fun getById(id: Int): Ingredient?
}