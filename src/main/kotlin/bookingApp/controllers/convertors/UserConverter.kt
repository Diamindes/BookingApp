package bookingApp.controllers.convertors

import bookingApp.controllers.UserDto
import bookingApp.repositories.entity.User
import org.springframework.stereotype.Component

@Component
class UserConverter {

    fun convertToDto(user: User): UserDto {
        return UserDto(
                id = user.id,
                login = user.login,
                password = "",
                fullname = user.fullname,
                telephone = user.telephone,
                role = user.roleType,
                restaurantId = user.restaurant?.id
        )
    }

    fun convertAllToDto(users: List<User>): List<UserDto> {
        return users.map(this::convertToDto).toList()
    }
}