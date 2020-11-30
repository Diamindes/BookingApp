package bookingApp.repositories.entity

import java.io.Serializable
import javax.persistence.*


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
        val tables: MutableList<TableEntity>? = mutableListOf(),

        @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
        val reservations: MutableList<Reservation> = mutableListOf()

        //        @OneToMany(mappedBy = "restaurant")
        //        val ordersList:MutableList<Order> = mutableListOf()
        ///??? val employeeList: MutableList<EmployeeEntity> = mutableListOf(),
) : Serializable