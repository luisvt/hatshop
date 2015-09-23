package com.hatshop

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module

/**
 * Created by luis on 6/19/15.
 */
class CustomObjectMapper extends ObjectMapper{
    public CustomObjectMapper() {
        def hibernateModule = new Hibernate4Module()
                .configure(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true)

        registerModule(hibernateModule);

        configure(SerializationFeature.INDENT_OUTPUT, true)
    }
}
