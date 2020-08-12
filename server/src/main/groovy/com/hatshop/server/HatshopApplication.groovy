package com.hatshop.server

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

import javax.sql.DataSource

import static org.springframework.web.method.HandlerTypePredicate.forAnnotation

@SpringBootApplication
class HatshopApplication implements CommandLineRunner, WebMvcConfigurer {

    @Autowired
    UserRepository userRepository
    @Autowired
    CustomerRepository customerRepository
    @Autowired
    ShippingRegionRepository shippingRegionRepository

    @Autowired
    DataSource dataSource

    static void main(String[] args) {
        SpringApplication.run(HatshopApplication, args)
    }

//    @Override
//    void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter(new CustomObjectMapper()))
//    }

//	@Bean
//	MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
//		new MappingJackson2HttpMessageConverter(new CustomObjectMapper())
//	}

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
