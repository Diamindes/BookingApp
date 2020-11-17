package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "dishes")
class Dish (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int? = null,

        val name: String,

        @ManyToMany
        @JoinTable(name = "dish_ingredient",
                joinColumns = [JoinColumn(name = "dish_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "ingredient_id", referencedColumnName = "id")])
        val ingredients: MutableList<Ingredient>
): Serializable