package bookingApp.repository.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name =  "BookingTable")
class OrderEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        val tableId: Int,
        val paymentId: Int,
        val dishesList: MutableList<DishEntity> = mutableListOf(),
        val date: Date,
        val userId: Int,
        val orderType: OrderTypeEntity
        ): Serializable
