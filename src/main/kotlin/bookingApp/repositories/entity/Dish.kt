package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "dishes")
class Dish(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        val name: String,

        val type: String,
        val price: String,

        @ManyToMany
        @JoinTable(name = "dish_ingredient",
                joinColumns = [JoinColumn(name = "dish_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "ingredient_id", referencedColumnName = "id")])
        val ingredients: MutableList<Ingredient>
) : Serializable