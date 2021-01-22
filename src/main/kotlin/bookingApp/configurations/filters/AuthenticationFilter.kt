package bookingApp.configurations.filters

import bookingApp.controllers.UserLoginDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(authenticationManager: AuthenticationManager) : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        return try {
            val user: UserLoginDto = jacksonObjectMapper().readValue(request.inputStream)
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(user.login, user.password, null))
        } catch (e: IOException) {
            throw RuntimeException("Could not read request$e")
        }
    }

    override fun successfulAuthentication(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain, authResult: Authentication) {
        var userPrincipal = authResult.principal as User

        val token = Jwts.builder()
                .setSubject(jacksonObjectMapper().writeValueAsString(UserLoginDto(userPrincipal.username, userPrincipal.password)))
                .setExpiration(Date(System.currentTimeMillis() + 864000000))
                .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs".toByteArray())
                .compact()
        response.addHeader("Authorization", "Bearer $token")
    }

    init {
        this.authenticationManager = authenticationManager
        setFilterProcessesUrl("/login")
    }
}