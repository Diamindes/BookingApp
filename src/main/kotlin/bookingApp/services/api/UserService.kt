package bookingApp.services.api

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.User

interface UserService {
    fun getReservations(userId: Int): List<Reservation>
    fun login(user: UserLoginDto): Boolean
    fun getById(id: Int): User
    fun getByLogin(login: String): User
    fun registerEmployee(user: UserDto, restaurantId: Int): User
    fun deleteEmployee(userId: Int, restaurantId: Int)
    fun getAll(restaurantId: Int): List<User>
    fun register(user: User): User
}