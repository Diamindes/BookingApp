package bookingApp.repositories

import bookingApp.repositories.entity.Restaurant
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository : PagingAndSortingRepository<Restaurant, Int>, JpaSpecificationExecutor<Restaurant> {

    fun getById(id: Int): Restaurant?
    fun getByName(name : String): Restaurant?
}