package bookingApp.services.api

import bookingApp.repositories.entity.User

interface AdminService {
    fun createWaiter(user: User): String
    fun deleteWaiter(user: User): String
    fun associateWaiterWithTable(): Boolean
}