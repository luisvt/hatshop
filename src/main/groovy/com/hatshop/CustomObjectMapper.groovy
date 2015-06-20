package com.hatshop

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module

/**
 * Created by luis on 6/19/15.
 */
class CustomObjectMapper extends ObjectMapper{
    public CustomObjectMapper() {
        registerModule(new Hibernate4Module());

        configure(SerializationFeature.INDENT_OUTPUT, true);
    }
}
