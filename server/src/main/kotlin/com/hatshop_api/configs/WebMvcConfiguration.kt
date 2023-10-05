package com.hatshop_api.configs

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.method.HandlerTypePredicate.forAnnotation
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfiguration : WebMvcConfigurer {
  override fun configurePathMatch(configurer: PathMatchConfigurer) {
    configurer.addPathPrefix("/api", forAnnotation(RestController::class.java))
  }
}
