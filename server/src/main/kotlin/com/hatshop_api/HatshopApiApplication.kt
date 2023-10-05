package com.hatshop_api

import com.lv_spring.data.rest.jpa.ObjectToSerializableAdvice
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(ObjectToSerializableAdvice::class)
class HatshopApiApplication

fun main(args: Array<String>) {
  runApplication<HatshopApiApplication>(*args)
}
