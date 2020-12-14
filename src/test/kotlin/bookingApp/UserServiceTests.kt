package bookingApp

//import org.junit.jupiter.api.Test
import bookingApp.repositories.UserRepository
import bookingApp.repositories.entity.Reservation
import bookingApp.repositories.entity.Restaurant
import bookingApp.repositories.entity.RoleType
import bookingApp.repositories.entity.User
import bookingApp.services.UserServiceImpl
import junit.framework.TestCase.assertEquals
import org.assertj.core.api.JUnitSoftAssertions
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
@ActiveProfiles("h2")
class UserServiceTests {

    @MockBean
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userService: UserServiceImpl

    @get:Rule
    var softly = JUnitSoftAssertions()

    @Test
    @Ignore
    fun `'getReservations' should retrieve empty list if repository doesn't contain entities`() {
        softly.assertThat(userService.getReservations(0)).isEmpty()
    }

    @Test
    fun `get not empty reservations`() {
        val reservations = listOf<Reservation>(
                Reservation(0, User(roleType = RoleType.USER), Restaurant(0, "rest"), null, null, 1L, 1L, 1L),
                Reservation(1, User(roleType = RoleType.USER), Restaurant(0, "rest"), null, null, 1L, 1L, 1L))

    }

    @Test
    fun `get user by id`() {
        val expected = User(0, "user", "user", "user user", "8545", RoleType.WAITER)
        given(this.userRepository.getById(anyInt()))
                .willReturn(expected)
        val newRegisteredUser = userService.getById(0)
        assertEquals(expected, newRegisteredUser)
    }


    /*
    fun getReservations(userId: Int): List<Reservation>
    fun register(data: UserDto): User
    fun login(user: UserLoginDto): Boolean
    fun getById(id: Int): User?
     */
}