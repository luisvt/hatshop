package com.hatshop_api.controllers

import com.hatshop_api.models.Tax
import com.hatshop_api.repositories.TaxRepository
import com.hatshop_api.utils.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("taxes")
class TaxController(repository: TaxRepository) : AbstractRestController<Tax, Int>(repository)
