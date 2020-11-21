package bookingApp.services.api

import bookingApp.controllers.UserDto
import bookingApp.repositories.entity.User

interface AdminService {
    fun registerEmployee(user: UserDto): User
    fun deleteEmployee(user: User): String
    fun associateWaiterWithTable(userId: Int, tableId: Int): Boolean
}