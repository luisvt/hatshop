package com.hatshop_api.security.controllers

import com.hatshop_api.security.models.EUser
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.web.csrf.CsrfToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Created by luis on 6/20/15.
 */
@RestController
@Tag(name = "Session User")
class SessionUserController {

  @GetMapping("/session-user")
  fun getSessionUser(
    @AuthenticationPrincipal user: EUser
  ): EUser = user

//  @GetMapping("/csrf")
//  fun getCsrf(csrfToken: CsrfToken) = csrfToken
}
