package bookingApp.services.api

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.User

interface UserService {
    fun getReservations(userId: Int): List<Reservation>
    fun register(data: UserDto): User
    fun login(user: UserLoginDto): Boolean
    fun getById(id: Int): User?
    fun registerEmployee(user: UserDto): User
    fun deleteEmployee(userId: Int): String
    fun getEmployees(restaurantId: Int): List<User>
    fun associateWaiterWithTable(userId: Int, tableId: Int): Boolean
    fun getAssociationsWithTable(restaurantId: Int): List<Pair<Int, Int>>
}