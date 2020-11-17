package bookingApp.repository.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "reservations")
class Reservation (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        @ManyToOne
        @JoinColumn(name = "userId", referencedColumnName = "id")
        val user: User,

        @ManyToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        val restaurant: Restaurant,

        @ManyToOne
        @JoinColumn(name = "tableId", referencedColumnName = "id")
        val table: TableEntity,

        @OneToOne
        @JoinColumn(name = "orderId", referencedColumnName = "id")
        val order : Order,

        val dateStartReservation : Date,
        val dateEndReservation : Date,
        val dateCreateReservation : Date
): Serializable
