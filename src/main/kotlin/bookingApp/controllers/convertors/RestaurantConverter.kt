package bookingApp.controllers.convertors

import bookingApp.controllers.RestaurantDto
import bookingApp.repositories.entity.Restaurant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RestaurantConverter {

    @Autowired
    private lateinit var reservationConverter: ReservationConverter

    fun convertToDto(restaurant: Restaurant): RestaurantDto {
        return RestaurantDto(restaurant.id, restaurant.name, reservationConverter.convertAllToDto(restaurant.reservations))
    }

    fun convertAllToDto(restaurant: Iterable<Restaurant>): List<RestaurantDto> {
        return restaurant.map(this::convertToDto).toList()
    }
}