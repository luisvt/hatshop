package com.hatshop.server.utils

import org.springframework.context.MessageSource
import org.springframework.data.rest.webmvc.RepositoryRestExceptionHandler
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice("com.hatshop.server")
class CustomRestExceptionHandler extends RepositoryRestExceptionHandler {
    CustomRestExceptionHandler(MessageSource messageSource) {
        super(messageSource)
    }
}
