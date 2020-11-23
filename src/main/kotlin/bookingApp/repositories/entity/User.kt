package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        var login: String?,
        var password: String?,
        var fullname: String?,
        var telephone: String?,

        // employee
        @Enumerated(EnumType.STRING)
        val roleType: RoleType,

        @ManyToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        val restaurant: Restaurant? = null,

        // customer
        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val reservations: MutableList<Reservation> = mutableListOf(),

        @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
        val orders: MutableList<Order> = mutableListOf(),

        @ManyToMany
        @JoinTable(name = "user_dish",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "dish_id", referencedColumnName = "id")])
        val favoriteDishes: MutableList<Dish> = mutableListOf(),
): Serializable