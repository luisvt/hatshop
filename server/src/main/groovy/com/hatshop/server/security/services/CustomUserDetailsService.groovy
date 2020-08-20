package com.hatshop.server.security.services

import com.hatshop.server.security.models.User
import com.hatshop.server.security.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
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
class CustomUserDetailsService implements UserDetailsService {

  private static final LOGGER = LoggerFactory.getLogger(CustomUserDetailsService)

  @Autowired
  private UserRepository userRepository

  @Override
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findOneByUsername(username)

    if (user == null) {
      String message = "Username not found: " + username
      LOGGER.info(message)
      throw new UsernameNotFoundException(message)
    }

    LOGGER.info("Found user in database: " + user)

    user
  }
}
