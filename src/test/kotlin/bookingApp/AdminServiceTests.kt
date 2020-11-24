package bookingApp

import bookingApp.controllers.UserDto
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import bookingApp.services.AdminServiceImpl
import bookingApp.services.UserServiceImpl
import junit.framework.TestCase.assertEquals
import org.junit.Test
//import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
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

    @Autowired
    private lateinit var adminService: AdminServiceImpl


    @Test
    fun `register employee`() {
        val user = UserDto(0, "user", "user", "user user", "8545", RoleType.WAITER)
        val expected = User(0, "user", "user", "user user", "8545", RoleType.WAITER)
        adminService.register(user)
        given(this.userRepository.getById(any()))
                .willReturn(expected)
        val newRegisteredUser = UserServiceImpl().getById(0)
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