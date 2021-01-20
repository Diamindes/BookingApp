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
@Table(name = "tables")
class TableEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        val restaurant: Restaurant,

        @ManyToOne
        @JoinColumn(name = "userId", referencedColumnName = "id")
        var waiter: User?,

        var isFree: Boolean,
        val numberName: Int,
        val numberOfSeats: Int,
        val isNearTheWindow: Boolean
): Serializable
