package bookingApp.repository.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "BookingTable")
class ReservationEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        val userId: Int,
        val restaurantId: Int,
        val tableId: Int,
        val dateStartReservation : Date,
        val dateEndReservation : Date,
        val dateCreateReservation : Date,
        val orderId : Int
): Serializable
