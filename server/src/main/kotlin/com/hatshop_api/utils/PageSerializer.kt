package com.hatshop_api.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.Page

@JsonComponent
class PageSerializer : JsonSerializer<Page<Any>>() {
  override fun serialize(value: Page<Any>, gen: JsonGenerator, serializers: SerializerProvider) {
    gen.writeStartObject()
    gen.writeNumberField("size", value.size)
    gen.writeNumberField("total", value.totalElements)
    gen.writeNumberField("number", value.number)
    gen.writeObjectField("items", value.content)
    gen.writeEndObject()
  }
}
