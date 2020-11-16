package bookingApp.repository.entity

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "BookingTable")
class RestaurantEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,

        val name: String,
        @ManyToMany
        val menusList: MutableList<MenuEntity> = mutableListOf(),
        val tablesList: MutableList<TableEntity> = mutableListOf(),
        val reservationList: MutableList<ReservationEntity> = mutableListOf(),
        val ordersList:MutableList<OrderEntity> = mutableListOf(),
        ///??? val employeeList: MutableList<EmployeeEntity> = mutableListOf(),
) : Serializable