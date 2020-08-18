package com.hatshop.server

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

import static com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS
import static org.springframework.web.method.HandlerTypePredicate.forAnnotation

@SpringBootApplication
class HatShopApplication implements WebMvcConfigurer {

    static void main(String[] args) {
        SpringApplication.run(HatShopApplication, args)
    }

    @Override
    void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> mc : converters) {
            if (mc instanceof MappingJackson2HttpMessageConverter
                    || mc instanceof MappingJackson2XmlHttpMessageConverter) {
                mc.objectMapper.registerModule(new Hibernate5Module()
                        .configure(SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true))
                mc.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
            }
        }
    }

    @Override
    void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/api", forAnnotation(RestController))
    }
}
