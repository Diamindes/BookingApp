package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table (name = "BookingTable")
class UserEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        var login: String?,
        var password: String?,
        var fullname: String = "",
        var telephone: String?,
        // employee
        val roleTypeEntity: RoleTypeEntity,
        val restaurantEntity: RestaurantEntity,

        // customer
        val reservationList: MutableList<ReservationEntity> = mutableListOf(),
        val ordersList: MutableList<OrderEntity> = mutableListOf(),
        val favoriteDishesList: MutableList<DishEntity> = mutableListOf()
): Serializable