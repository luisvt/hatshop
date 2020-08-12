package com.hatshop.server.controllers

import com.hatshop.server.utils.AbstractRestController
import com.hatshop.server.models.Review
import com.hatshop.server.repositories.ReviewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("reviews")
class ReviewController extends AbstractRestController<Review, Integer> {
    @Autowired
    ReviewController(ReviewRepository repo) {
        super(repo)
    }
}
