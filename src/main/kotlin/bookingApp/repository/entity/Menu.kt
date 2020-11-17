package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "menus")
class Menu (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        @OneToOne
        @JoinColumn(name = "restaurantId", referencedColumnName = "id")
        val restaurant: Restaurant,

        @ManyToMany
        val dishesList: MutableList<Dish>
): Serializable