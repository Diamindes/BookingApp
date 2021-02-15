package bookingApp.services

import bookingApp.controllers.RestaurantDto
import bookingApp.repositories.RestaurantRepository
import bookingApp.repositories.entity.Restaurant
import bookingApp.services.utils.FilterDTO
import bookingApp.services.utils.PageRequestHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import javax.persistence.criteria.Root
import kotlin.streams.toList


@Service
class RestaurantService {

    @Autowired
    private lateinit var restaurantRepository: RestaurantRepository

    fun getById(id: Int): Restaurant {
        return restaurantRepository.getById(id)
    }

    fun saveToDb(data: Restaurant): Restaurant = restaurantRepository.save(data)

    fun getAllRestaurants(): List<RestaurantDto> {
        return restaurantRepository.findAll()
                .map(this::convertRestaurants)
                .toList()
    }


    private fun convertRestaurants(restaurant: Restaurant): RestaurantDto {
        return RestaurantDto(restaurant.id, restaurant.name)
    }

    fun getByCriteria(pageRequest: PageRequestHolder): Page<Restaurant>? {
        return restaurantRepository.findAll(processFilters(pageRequest.filters), pageRequest.pageRequest)
    }

    private fun processFilters(filters: List<FilterDTO>): Specification<Restaurant?>? {
        var criteria = Specification.where { book: Root<Restaurant?>, _, builder -> builder.like(book.get("name"), "%%") }

        for (filter in filters) {
            when (filter.property) {
                    "name" -> criteria = criteria.and { book, _, builder -> builder.like(book.get("name"), "%${filter.value}%") }
            }
        }

        return criteria
    }
}