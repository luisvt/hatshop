package com.hatshop_api.utils

import com.hatshop_api.utils.Constants.PAGE_NUMBER
import com.hatshop_api.utils.Constants.PAGE_SIZE
import java.io.Serializable
import kotlin.reflect.KProperty1
import org.slf4j.LoggerFactory
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

abstract class AbstractRestController<T, ID : Serializable>(
  val repo: JpaRepository<T, ID>
) {

  @GetMapping("/{id}")
  fun findOne(@PathVariable id: ID): T {
    return repo.findById(id).orElseThrow { ResourceNotFoundException() }
  }

  @GetMapping("/{id}/{property}")
  fun findProperty(
    @PathVariable id: ID,
    @PathVariable property: String,
  ): Any? {
    val item = repo.findById(id).orElseThrow { ResourceNotFoundException() }!!
    if (item::class.members.any { it.name == property }) {
      val prop = item::class.members.first { it.name == property } as KProperty1<T, *>
      return prop.get(item)
    } else {
      throw ResourceNotFoundException()
    }
  }

  @GetMapping
  fun findAll(
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int,
    @RequestParam(required = false) search: String? = null,
  ): Any? {
    logger.info(
      """
            |Finding All.
            |   size: $size
            |   page: $page
            |   search: $search
        """.trimMargin()
    )
    return when (size) {
      0 -> repo.findAll()
      1 -> repo.findAll(PageRequest.of(page, size)).elementAt(0)
      else -> repo.findAll(PageRequest.of(page, size))
    }
  }

  @PostMapping
  fun create(@RequestBody entity: T?): T {
    logger.debug("create with body {} of type {}", entity, entity!!::class)

    return repo.save(entity)
  }


  @PutMapping("/{id}")
  fun update(@PathVariable id: ID, @RequestBody item: T): T {
    logger.debug("update() of id#{} with body {}", id, item)
    logger.debug("T json is of type {}", item!!::class)

    val entity = repo.findById(id).orElseThrow { ResourceNotFoundException() }!!
    try {
      BeanUtils.copyProperties(entity, item)
    } catch (e: Exception) {
      logger.warn("Error while copying properties", e)
    }

    logger.debug("merged entity: {}", entity)

    return repo.save(entity)
  }

  @DeleteMapping("/{id}")
  fun deleteById(@PathVariable id: ID) = repo.deleteById(id)

  companion object {
    @JvmStatic
    private val logger = LoggerFactory.getLogger(AbstractRestController::class.java)
  }
}
