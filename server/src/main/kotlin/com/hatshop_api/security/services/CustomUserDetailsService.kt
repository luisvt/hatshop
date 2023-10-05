package com.hatshop_api.security.services

import com.hatshop_api.security.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 *
 * UserDetails service that reads the user credentials from the database, using a JPA repository.
 *
 */
@Service
class CustomUserDetailsService(
  private val userRepository: UserRepository
) : UserDetailsService {

  companion object {
    private val LOGGER = LoggerFactory.getLogger(CustomUserDetailsService::class.java)
  }

  @Throws(UsernameNotFoundException::class)
  override fun loadUserByUsername(username: String): UserDetails {
    val user = userRepository.findOneByUsername(username)

    if (user == null) {
      val message = "Username not found: $username"
      LOGGER.info(message)
      throw UsernameNotFoundException(message)
    }

    LOGGER.info("Found user in database: $user")

    return user
  }
}
