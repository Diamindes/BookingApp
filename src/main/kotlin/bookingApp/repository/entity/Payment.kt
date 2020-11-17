package bookingApp.repository.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "payments")
class Payment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        @Enumerated(EnumType.STRING)
        val paymentType: PaymentType,

        val date: Date,
        val checkId: Int //TODO: ??
): Serializable