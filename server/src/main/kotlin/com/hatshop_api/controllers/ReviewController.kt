package com.hatshop_api.controllers

import com.hatshop_api.models.Review
import com.hatshop_api.repositories.ReviewRepository
import com.hatshop_api.utils.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("reviews")
class ReviewController(repository: ReviewRepository) : AbstractRestController<Review, Int>(repository)
