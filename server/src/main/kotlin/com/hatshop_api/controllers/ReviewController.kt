package com.hatshop_api.controllers

import com.hatshop_api.models.Review
import com.hatshop_api.repositories.ReviewRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("reviews")
@Tag(name = "Reviews")
class ReviewController(repository: ReviewRepository) : AbstractRestController<Review, Int>(repository)
