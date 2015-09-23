package com.hatshop.security.controllers

import com.hatshop.security.models.User
import com.hatshop.security.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.security.core.Authentication
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpSession
import java.security.Principal

/**
 * Created by luis on 6/20/15.
 */
@RestController
class SessionUserController {
    @Autowired Environment environment
    @Autowired UserRepository userRepository

    @RequestMapping("/session-user")
    User getSessionUser(@AuthenticationPrincipal User user, HttpSession session) {
        if(environment.acceptsProfiles('default')) {
            return userRepository.findOneByUsername('user1')
        }
        user
    }

}
