package bookingApp.services.api

import bookingApp.controllers.UserDto
import bookingApp.controllers.UserLoginDto
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.User

interface UserService { // for all users
    fun getReservations(id: Int): List<Reservation>
    fun register(data: UserDto): User
    fun login(user: UserLoginDto): Boolean
    fun getById(id: Int): User?
}