package com.hatshop.server.repositories


import com.hatshop.server.models.Category
import com.hatshop.server.models.Department
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageRequest

import static org.junit.jupiter.api.Assertions.assertEquals

/**
 * Test for ProductRepository
 * Created by luis on 7/9/15.
 */
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository

    @Autowired
    DepartmentRepository departmentRepository

    @Autowired
    CategoryRepository categoryRepository

    @Test
    void testFindAllByCategories_Department_Id() throws Exception {
        def dep2 = departmentRepository.findOne(Example.of(new Department(name: 'Caps and Berets'))).get()
        def productsPage = productRepository.findAllByCategories_Department_Id(dep2.id, PageRequest.of(0, 50))

        assertEquals 8, productsPage.content.size()
    }

    @Test
    void testFindAllByCategories_Id() {
        def cat1 = categoryRepository.findOne(Example.of(new Category(name: 'Christmas Hats'))).get()
        def productsPage = productRepository.findAllByCategories_Id(cat1.id, PageRequest.of(0, 20))

        assertEquals 7, productsPage.content.size()
    }
}
