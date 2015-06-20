package com.hatshop.controllers

import com.hatshop.AbstractRestController
import com.hatshop.models.Product
import com.hatshop.repositories.ProductRepository
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
