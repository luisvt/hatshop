package com.hatshop

import com.hatshop.models.Customer
import com.hatshop.models.ShippingRegion
import com.hatshop.repositories.CustomerRepository
import com.hatshop.repositories.ShippingRegionRepository
import com.hatshop.security.models.Role
import com.hatshop.security.models.User
import com.hatshop.security.repositories.UserRepository
import com.hatshop.utils.CustomObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.support.EncodedResource
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.jdbc.datasource.init.ScriptUtils
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import javax.sql.DataSource

@SpringBootApplication
class HatShopApplication implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run HatShopApplication.class
    }

    @Autowired UserRepository userRepository
    @Autowired CustomerRepository customerRepository
    @Autowired ShippingRegionRepository shippingRegionRepository

    @Autowired DataSource dataSource

//    @Override
//    void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter(new CustomObjectMapper()))
//    }

    @Bean
    MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(new CustomObjectMapper())
    }

    @Override
    void run(String... args) throws Exception {

        def roleUser = new Role(authority: "ROLE_USER"),
            encoder = new BCryptPasswordEncoder()

        userRepository.saveAll([
                new User("user1", encoder.encode("password1"), [roleUser]),
                new User("user2", encoder.encode("password2"), [roleUser])
        ])

        def resource = new EncodedResource(new ClassPathResource("_data.sql"))
        ScriptUtils.executeSqlScript(dataSource.connection, resource, true, true, '--', ';', '/*', '/*')

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