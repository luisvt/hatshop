package com.hatshop.server.security.controllers

import com.hatshop.server.security.models.User
import com.hatshop.server.security.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static com.hatshop.server.utils.ToSerializable.toSerializable

/**
 * Created by luis on 6/20/15.
 */
@RestController
class SessionUserController {
  @Autowired
  Environment environment
  @Autowired
  UserRepository userRepository

  @RequestMapping("/session-user")
  def getSessionUser(@AuthenticationPrincipal User user, @RequestParam(required = false) List<String> project) {
    toSerializable user, project
  }

}
