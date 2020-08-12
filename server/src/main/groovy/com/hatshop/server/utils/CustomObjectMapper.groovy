package com.hatshop.server.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer
import org.springframework.boot.jackson.JsonObjectSerializer

/**
 * Object mapper that adds serialization for hibernate lazy-not-loaded objects
 */
class CustomObjectMapper extends ObjectMapper {

    CustomObjectMapper() {
//        registerModule(new SimpleModule('CustomHibernateModule', new Version(1, 0, 0, null))
//                .addSerializer(JavassistLazyInitializer, new HibernateLazyInitializerSerializer()))

        registerModule(new Hibernate5Module()
                .configure(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true))
//
//        registerModule(hibernateModule)

//        configure(SerializationFeature.INDENT_OUTPUT, true)
//        println getRegisteredModuleIds()
    }

    static class HibernateLazyInitializerSerializer extends JsonSerializer<JavassistLazyInitializer> {

        @Override
        void serialize(JavassistLazyInitializer initializer,
                       JsonGenerator jsonGenerator,
                       SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            jsonGenerator.writeNull()
        }
    }

    static class CustomSerializer extends JsonSerializer<Object> {
        @Override
        void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            String customValue = '' // someService.getCustomValue(value);
            jgen.writeString(customValue)
        }
    }

    static class MyBeanSerializerModifier extends BeanSerializerModifier {
        @Override
        List<BeanPropertyWriter> changeProperties(SerializationConfig config,
                                                  BeanDescription beanDesc,
                                                  List<BeanPropertyWriter> beanProperties) {
            for (int i = 0; i < beanProperties.size(); i++) {
                BeanPropertyWriter beanPropertyWriter = beanProperties.get(i)
                beanPropertyWriter.getType().
                        if('handler' == beanPropertyWriter.getName()) {
                            beanProperties.set(i, beanPropertyWriter.assignSerializer(new CustomSerializer()))
                        }
            }
            return beanProperties
        }
    }
}
