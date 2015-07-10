package com.hatshop.repositories

import com.hatshop.HatshopApplication
import com.hatshop.models.Product
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import static org.junit.Assert.assertEquals

/**
 * Test for ProductRepository
 * Created by luis on 7/9/15.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = HatshopApplication)
@WebAppConfiguration
public class ProductRepositoryTest {

    @Autowired ProductRepository productRepository

    @Test
    public void testFindAllByDepartmentId() throws Exception {
        Page<Product> productsPage = productRepository.findPageByDepartmentId(2, new PageRequest(0, 50))

        assertEquals 8, productsPage.content.size()
    }

    @Test
    public void testFindAllByCategoryId() {
        def productsPage = productRepository.findPageByCategoryId(1, new PageRequest(0, 20));

        assertEquals 7, productsPage.content.size()
    }
}