package com.hatshop.security.services

import com.hatshop.security.models.User
import com.hatshop.security.repositories.UserRepository
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service

/**
 *
 * UserDetails service that reads the user credentials from the database, using a JPA repository.
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUsername(username);

        if (user == null) {
            String message = "Username not found: " + username;
            LOGGER.info(message);
            throw new UsernameNotFoundException(message);
        }

        LOGGER.info("Found user in database: " + user);

        user
    }
}
