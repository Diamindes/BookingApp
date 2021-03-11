package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table


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

        var reservationStartTime: Int,

        var reservationEndTime: Int
): Serializable
