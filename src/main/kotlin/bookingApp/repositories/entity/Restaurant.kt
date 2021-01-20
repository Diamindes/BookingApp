package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "restaurants")
class Restaurant(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        val name: String,

        @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
        val reservations: MutableList<Reservation> = mutableListOf(),
) : Serializable