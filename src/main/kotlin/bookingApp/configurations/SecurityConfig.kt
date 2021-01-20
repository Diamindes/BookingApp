package bookingApp.configurations

import bookingApp.configurations.filters.AuthenticationFilter
import bookingApp.configurations.filters.AuthorizationFilter
import bookingApp.repositories.UserRepository
import bookingApp.services.SecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
                .userDetailsService<UserDetailsService>(SecurityService(userRepository))
                .passwordEncoder(BCryptPasswordEncoder())
    }

    override fun configure(http: HttpSecurity) {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                    .anyRequest().permitAll()
                .and()
                    .addFilter(AuthenticationFilter(authenticationManager()))
                    .addFilter(AuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}