package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "BookingTable")
class MenuEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        val restaurantId:Int,
        val dishesList: MutableList<DishEntity> = mutableListOf()
): Serializable