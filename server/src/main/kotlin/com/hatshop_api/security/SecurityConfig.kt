package com.hatshop_api.security

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod.GET
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler

@Configuration
@EnableWebSecurity
class SecurityConfig(
  val userDetailsService: UserDetailsService
) {

  companion object {
    @JvmStatic
    private val LOGGER = LoggerFactory.getLogger(SecurityConfig::class.java)
  }

  @Bean
  fun passwordEncoder() = BCryptPasswordEncoder()

  fun configure(auth: AuthenticationManagerBuilder) {
    LOGGER.debug("configuring AuthenticationManagerBuilder")
    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder())
  }

  @Bean
  fun filterChain(http: HttpSecurity): SecurityFilterChain {
    LOGGER.debug("configuring HttpSecurity")
    http {
      authorizeRequests {
        listOf("/*", "/assets/**", "/fonts/**").forEach { authorize(it, permitAll) }
        listOf("/api/products/**", "/api/departments/**", "/api/categories/**").forEach {
          authorize(
            GET,
            it,
            permitAll
          )
        }
        listOf("/api/hal/products/**", "/api/hal/departments/**", "/api/hal/categories/**").forEach {
          authorize(
            GET,
            it,
            permitAll
          )
        }
        authorize("/api/session-user", authenticated)
        authorize("/api/**", hasRole("ADMIN"))
//        authorize("/h2-console/**", permitAll)
      }
      httpBasic {}
      logout {
        logoutUrl = "/api/logout"
      }
      csrf {
        disable()
//        csrfTokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse()
//        csrfTokenRequestHandler = CsrfTokenRequestAttributeHandler()
//        ignoringRequestMatchers("/h2-console/**")
      }
//      sessionManagement {
//        sessionCreationPolicy = SessionCreationPolicy.STATELESS
//      }
      headers {
        frameOptions { disable() }
      }
    }

    return http.build()
  }

}
