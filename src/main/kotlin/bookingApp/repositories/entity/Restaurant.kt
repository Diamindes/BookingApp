package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "restaurants")
class Restaurant(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        val name: String,

        @OneToOne
        @JoinColumn(name = "menuId", referencedColumnName = "id")
        val menu: Menu? = null,


        @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
        val reservations: MutableList<Reservation> = mutableListOf(),

//        val ordersList:MutableList<Order> = mutableListOf()
) : Serializable