package bookingApp.configurations.filters

import bookingApp.controllers.UserLoginDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthorizationFilter(authenticationManager: AuthenticationManager?) : BasicAuthenticationFilter(authenticationManager) {

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val header = request.getHeader("Authorization")
        if (header == null || !header.startsWith("Bearer")) {
            chain.doFilter(request, response)
            return
        }
        val authenticationToken = getAuthentication(request)
        SecurityContextHolder.getContext().authentication = authenticationToken
        chain.doFilter(request, response)
    }

    private fun getAuthentication(request: HttpServletRequest): UsernamePasswordAuthenticationToken? {
        val token = request.getHeader("Authorization")
        if (token != null) {
            val userData: UserLoginDto = jacksonObjectMapper()
                    .readValue(Jwts.parser().setSigningKey("SecretKeyToGenJWTs".toByteArray())
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .body
                    .subject)
            return UsernamePasswordAuthenticationToken(userData.login, null, null)
        }
        return null
    }
}