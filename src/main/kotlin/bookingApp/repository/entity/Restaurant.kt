package bookingApp.repository.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
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
        val menu: Menu,

        @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
        val tables: MutableList<TableEntity>,

        @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
        val reservations: MutableList<Reservation>

        //        @OneToMany(mappedBy = "restaurant")
        //        val ordersList:MutableList<Order> = mutableListOf()
        ///??? val employeeList: MutableList<EmployeeEntity> = mutableListOf(),
) : Serializable