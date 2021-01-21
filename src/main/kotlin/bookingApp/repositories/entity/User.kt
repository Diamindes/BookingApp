package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var login: String,
        var password: String,
        var fullname: String? = "",
        var telephone: String? = "",

        @Enumerated(EnumType.STRING)
        val roleType: RoleType?,

        @ManyToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        val restaurant: Restaurant? = null,

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val reservations: MutableList<Reservation> = mutableListOf(),
) : Serializable