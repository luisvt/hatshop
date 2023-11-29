package com.hatshop_api.controllers

import com.hatshop_api.models.Product
import com.hatshop_api.repositories.ProductRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("products")
@Tag(name = "Products")
class ProductController(repository: ProductRepository) : AbstractRestController<Product, Int>(repository)
