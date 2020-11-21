package bookingApp.services.api

import bookingApp.controllers.UserDto
import bookingApp.repositories.entity.User

interface AdminService {
    fun registerEmployee(user: UserDto): User
    fun deleteEmployee(userId: Int): String
    fun getEmployees(restaurantId: Int): List<User>
    fun associateWaiterWithTable(userId: Int, tableId: Int): Boolean
}