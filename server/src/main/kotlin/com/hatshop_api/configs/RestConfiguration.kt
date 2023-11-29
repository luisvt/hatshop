package com.hatshop_api.configs

import jakarta.persistence.EntityManager
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
//import org.springframework.web.servlet.config.annotation.CorsRegistry

//@Configuration
class RestConfiguration(
  val entityManager: EntityManager
) /*: RepositoryRestConfigurer {
  override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?, cors: CorsRegistry?) {
    val classes = entityManager.metamodel.entities.map { it.javaType }.toTypedArray()
    config?.exposeIdsFor(*classes)
  }
}*/
