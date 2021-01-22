package bookingApp.services

import bookingApp.repositories.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.*


class SecurityService(private val userRepository: UserRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(login: String): UserDetails {
        val userAuth = userRepository.getByLogin(login)
        return User(userAuth.login, userAuth.password, Collections.emptyList())
    }
}