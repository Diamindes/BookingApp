package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name =  "BookingTable")
class TableEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        val numberName:Int,
        val numberOfSeats : Int,
        val IsNearTheWindow : Boolean,
        val restaurantEntity: RestaurantEntity
): Serializable
