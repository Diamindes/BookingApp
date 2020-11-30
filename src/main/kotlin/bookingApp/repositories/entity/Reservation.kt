package bookingApp.repositories.entity

import java.io.Serializable
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
        var table: TableEntity? = null,

        @OneToOne
        @JoinColumn(name = "orderId", referencedColumnName = "id")
        var order: Order? = null,

        val dateStartReservation: Long,
        val dateEndReservation: Long,
        val dateCreateReservation: Long
): Serializable
