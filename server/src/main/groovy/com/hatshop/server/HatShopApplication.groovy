package com.hatshop.server

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import com.hatshop.server.models.Customer
import com.hatshop.server.models.ShippingRegion
import com.hatshop.server.repositories.CustomerRepository
import com.hatshop.server.repositories.ShippingRegionRepository
import com.hatshop.server.security.models.Role
import com.hatshop.server.security.models.User
import com.hatshop.server.security.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

import javax.sql.DataSource

import static com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS
import static org.springframework.web.method.HandlerTypePredicate.forAnnotation

@SpringBootApplication
class HatShopApplication implements CommandLineRunner, WebMvcConfigurer {

    @Autowired
    UserRepository userRepository
    @Autowired
    CustomerRepository customerRepository
    @Autowired
    ShippingRegionRepository shippingRegionRepository

    @Autowired
    DataSource dataSource

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

    @Override
    void run(String... args) throws Exception {

        def roleUser = new Role(authority: "ROLE_USER"),
            encoder = new BCryptPasswordEncoder()

        userRepository.saveAll([
                new User("user1", encoder.encode("password1"), [roleUser]),
                new User("user2", encoder.encode("password2"), [roleUser])
        ])

//		def resource = new EncodedResource(new ClassPathResource("_data.sql"))
//		ScriptUtils.executeSqlScript(dataSource.connection, resource, true, true, '--', ';', '/*', '*/')

        def shippingRegion = new ShippingRegion(1, 'region1')
        shippingRegionRepository.save(shippingRegion)

        shippingRegion.customers = customerRepository.saveAll([
                new Customer(
                        id: 1,
                        name: 'cust1',
                        password: 'pass1',
                        email: 'cust1@email.com',
                        shippingRegion: shippingRegion
                )
        ])

        shippingRegionRepository.save(shippingRegion)
    }
}
