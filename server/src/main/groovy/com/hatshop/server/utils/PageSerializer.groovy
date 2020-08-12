package com.hatshop.server.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import org.springframework.data.domain.Page

@JsonComponent
class PageSerializer extends JsonSerializer<Page<Object>> {
    @Override
    void serialize(Page<Object> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject()
        gen.writeNumberField("size", value.size)
        gen.writeNumberField("totalElements", value.totalElements)
        gen.writeNumberField("totalPages", value.totalPages)
        gen.writeNumberField("number", value.number)
        gen.writeObjectField("items", value.content)
        gen.writeEndObject()
    }
}
