package bookingApp.repository.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.*

@Entity
@Table(name = "BookingTable")
class PaymentEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        val date: Date,
        val paymentType: PaymentTypeEntity,
        val checkId: Int
): Serializable