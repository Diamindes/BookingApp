package bookingApp.repository.entity

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "BookingTable")
class PaymentTypeEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        val name: String,
) : Serializable
