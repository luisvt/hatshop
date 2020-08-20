package com.hatshop.server.controllers

import com.hatshop.server.models.Product
import com.hatshop.server.repositories.ProductRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("products")
class ProductController extends AbstractRestController<Product, Integer> {
  @Autowired
  ProductController(ProductRepository repo) {
    super(repo)
  }
}
