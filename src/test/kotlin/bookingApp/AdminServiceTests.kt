package bookingApp

import bookingApp.controllers.UserDto
import bookingApp.repositories.RestaurantRepository
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import bookingApp.services.api.UserService
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.notNull
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles( "h2")
class AdminServiceTests {

    @MockBean
    private lateinit var userRepository: UserRepository

    @MockBean
    private lateinit var restaurantRepository: RestaurantRepository

    @Autowired
    private lateinit var adminService: UserService

    @Test
    fun `register employee`() {
        val user = UserDto(1, "user", "user", "user user", "8545", RoleType.WAITER)
        val expected = User(1, "user", "user", "user user", "8545", RoleType.WAITER)

        given(this.userRepository.getById(anyInt()))
                .willReturn(expected)
        given(this.userRepository.save(notNull()))
                .willReturn(expected)

        adminService.registerEmployee(user, 1)

        val newRegisteredUser = adminService.getById(1)
        assertEquals("Users not equals", expected, newRegisteredUser)
    }
    /*
    fun registerEmployee(user: UserDto): User
    fun deleteEmployee(userId: Int): String
    fun getEmployees(restaurantId: Int): List<User>
    fun associateWaiterWithTable(userId: Int, tableId: Int): Boolean
    fun getAssociationsWithTable(restaurantId: Int): List<Pair<Int, Int>>
    */
}