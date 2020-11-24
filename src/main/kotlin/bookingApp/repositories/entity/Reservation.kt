package bookingApp.repositories.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.*


@Entity
@Table(name = "reservations")
class Reservation(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "userId", referencedColumnName = "id")
        var user: User,

        @ManyToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        var restaurant: Restaurant,

        @ManyToOne
        @JoinColumn(name = "tableId", referencedColumnName = "id")
        var table: TableEntity,

        @OneToOne
        @JoinColumn(name = "orderId", referencedColumnName = "id")
        var order: Order,

        val dateStartReservation: Date,
        val dateEndReservation: Date,
        val dateCreateReservation: Date
): Serializable
