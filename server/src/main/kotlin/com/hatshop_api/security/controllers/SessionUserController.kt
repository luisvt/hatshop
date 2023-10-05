package com.hatshop_api.security.controllers

import com.hatshop_api.security.models.EUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Created by luis on 6/20/15.
 */
@RestController
class SessionUserController {

  @GetMapping("/session-user")
  fun getSessionUser(
    @AuthenticationPrincipal user: EUser
  ): EUser = user

}
