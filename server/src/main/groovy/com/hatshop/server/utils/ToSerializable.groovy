package com.hatshop.server.utils

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.proxy.HibernateProxy
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

import javax.persistence.Entity
import javax.persistence.Id
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType

static Map toSerializable(Object item, project = null) {
    def serializable = [:]

    getDeclaredFields(item).each {
        def fieldName = it.name
//        println "fieldName = $fieldName"
        def fieldValue = item[fieldName]
//        println "fieldValue = $fieldValue"

        if (fieldValue != null) {
//            println "it.type = $it.type"
            if (fieldValue instanceof Collection
                    && it.genericType instanceof ParameterizedType
                    && ((Class<?>) ((ParameterizedType) it.genericType).actualTypeArguments[0]).annotations.any { it instanceof Entity }) {
//                println "Serializing List: $fieldValue"
                if (project instanceof String && project == fieldName
                        || project instanceof List<String> && project.contains(fieldName)) {
                    serializable[fieldName] = fieldValue.collect { toSerializable(it) }
                } else if (project instanceof Map && project[fieldName]) {
                    serializable[fieldName] = fieldValue.collect { toSerializable(it, project[fieldName]) }
//                } else {
//                    serializable[fieldName] = fieldValue.collect { toObjectId(it) }
                }
            } else if (it.type.annotations.any { it instanceof Entity }) {
//                println 'Serializing Projection'
//                println "project = $project"
                if (project instanceof String && project == fieldName
                        || project instanceof List<String> && project.contains(fieldName)) {
                    serializable[fieldName] = toSerializable(fieldValue)
                } else if (project instanceof Map && project[fieldName]) {
                    serializable[fieldName] = toSerializable(fieldValue, project[fieldName])
//                } else {
////                    println 'Serializing to ObjectWithIdOnly'
//                    serializable[fieldName] = toObjectId(fieldValue)
                }
            } else {
//                println "it.annotations = $it.annotations"
                if (!it.annotations.any {
                    it instanceof JsonIgnore ||
                            it instanceof JsonProperty && it.access() == JsonProperty.Access.WRITE_ONLY
                }) {
//                    println "serializable[$fieldValue] = $fieldValue"
                    serializable[fieldName] = fieldValue
                }
            }
        }
    }

    serializable
}

static Collection toSerializable(Collection items, project = null) {
    items.collect { toSerializable(it, project) }
}

static Page<?> toSerializable(Page<?> page, project = null) {
    new PageImpl(toSerializable(page.content, project), page.pageable, page.totalElements)
}

static private getDeclaredFields(Object item) {
    def clazz = item instanceof HibernateProxy ? item.class.superclass : item.class
//    println "clazz = $clazz"

    getSubFields(clazz).findAll {
//        println "getDeclaredFields it.name = $it.name"
        it.name != 'class' &&
                it.name != '$staticClassInfo' &&
                it.name != '__$stMC' &&
                it.name != 'metaClass' &&
                it.name != '$staticClassInfo$' &&
                it.name != '$callSiteArray'
    }
}

static private Field[] getSubFields(Class<?> clazz) {
    def fields = new HashSet(clazz.declaredFields.toList())
    while (clazz.superclass != Object) {
//        println "clazz.superclass = $clazz.superclass"
        fields.addAll(clazz.superclass.declaredFields)
        clazz = clazz.superclass
    }
    fields
}

static private toObjectId(Object fieldValue) {
//    println "fieldValue = $fieldValue"
//    println "fieldValue.class = ${fieldValue.class}"
    def idField = getDeclaredFields(fieldValue)
            .find { it.annotations.any { it instanceof Id } }
            .name
//    println "idField = $idField"
    [(idField): fieldValue[idField]]
}
