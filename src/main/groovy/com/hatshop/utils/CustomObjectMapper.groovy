package com.hatshop.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module

/**
 * Object mapper that adds serialization for hibernate lazy-not-loaded objects
 */
class CustomObjectMapper extends ObjectMapper{
    CustomObjectMapper() {
        def hibernateModule = new Hibernate4Module()
                .configure(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true)

        registerModule(hibernateModule)

//        configure(SerializationFeature.INDENT_OUTPUT, true)
    }
}
