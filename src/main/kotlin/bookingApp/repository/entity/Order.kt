package bookingApp.repository.entity

import java.io.Serializable
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "orders")
class Order (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        @OneToOne
        @JoinColumn(name = "tableId", referencedColumnName = "id")
        val tables: TableEntity,

        @OneToOne
        @JoinColumn(name = "paymentId", referencedColumnName = "id")
        val payment: Payment,

        @ManyToMany
        val dishes: MutableList<Dish>,

        val date: Date,

        @ManyToOne
        @JoinColumn(name = "userId", referencedColumnName = "id")
        val user: User,

        @Enumerated(EnumType.STRING)
        val orderType: OrderType
): Serializable
