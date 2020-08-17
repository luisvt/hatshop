package com.hatshop.server

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import com.hatshop.server.models.Category
import com.hatshop.server.models.Customer
import com.hatshop.server.models.Department
import com.hatshop.server.models.ShippingRegion
import com.hatshop.server.repositories.CategoryRepository
import com.hatshop.server.repositories.CustomerRepository
import com.hatshop.server.repositories.DepartmentRepository
import com.hatshop.server.repositories.ShippingRegionRepository
import com.hatshop.server.security.models.Role
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
    DepartmentRepository departmentRepository
    @Autowired
    CategoryRepository categoryRepository

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

//        userRepository.saveAll([
//                new User("user1", encoder.encode("password1"), [roleUser]),
//                new User("user2", encoder.encode("password2"), [roleUser])
//        ])

//		def resource = new EncodedResource(new ClassPathResource("_data.sql"))
//		ScriptUtils.executeSqlScript(dataSource.connection, resource, true, true, '--', ';', '/*', '*/')

        def shippingRegion = new ShippingRegion(1, 'region1')
        shippingRegionRepository.save(shippingRegion)

        shippingRegion.customers = customerRepository.saveAll([
                new Customer(
                        id: 1,
                        firstName: 'customer1',
                        lastName: 'customer1',
                        username: 'customer1',
                        password: encoder.encode("password1"),
                        email: 'customer1@email.com',
                        shippingRegion: shippingRegion
                )
        ])

        shippingRegionRepository.save(shippingRegion)


        def dep1 = new Department('Holiday', 'Prepare for the holidays with our special collection of seasonal hats!')
        def dep2 = new Department('Caps and Berets', 'The perfect hats to wear at work and costume parties!')
        def dep3 = new Department('Costume Hats', 'Find the matching hat for your new costume!')
        departmentRepository.saveAll([dep1, dep2, dep3])

        categoryRepository.saveAll([
                new Category(dep1, 'Christmas Hats', 'Enjoy browsing our collection of Christmas hats!'),
                new Category(dep1, 'Halloween Hats', 'Find the hat you\'ll wear this Halloween!'),
                new Category(dep1, 'St. Patrick\'s Day Hats', 'Try one of these beautiful hats on St. Patrick\'s Day!'),
                new Category(dep2, 'Berets', 'An amazing collection of berets from all around the world!'),
                new Category(dep2, 'Driving Caps', 'Be an original driver! Buy a driver\'s hat today!'),
                new Category(dep3, 'Theatrical Hats', 'Going to a costume party? Try one of these hats to complete your costume!'),
                new Category(dep3, 'Military Hats', 'This collection contains the most realistic replicas of military hats!')
        ])
    }
}
