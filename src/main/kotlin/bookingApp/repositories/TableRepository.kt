package bookingApp.repositories

import bookingApp.repositories.entity.TableEntity
import bookingApp.repositories.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TableRepository : JpaRepository<TableEntity, Int> {

    fun getById(id: Int): TableEntity
    fun getByWaiterAndRestaurantId(waiter: User, restaurantId: Int): List<TableEntity>
    fun getByRestaurantId(restaurantId: Int): List<TableEntity>
}