package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "tables")
class TableEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        val restaurant: Restaurant,

        var employeeId: Int,
        val numberName: Int,
        val numberOfSeats: Int,
        val IsNearTheWindow: Boolean
): Serializable
