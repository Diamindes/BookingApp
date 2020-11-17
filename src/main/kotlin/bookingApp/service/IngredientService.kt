package bookingApp.service

import bookingApp.repository.IngredientRepository
import bookingApp.repository.entity.IngredientEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IngredientService {

    @Autowired
    private lateinit var ingredientRepository: IngredientRepository

    fun getDataById(id: Int): IngredientEntity? {
        return ingredientRepository.getById(id)
    }

    fun saveToDb(data: IngredientEntity): IngredientEntity {
        return ingredientRepository.save(data)
    }
}