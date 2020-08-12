package com.hatshop.server.repositories

import com.hatshop.HatShopApplication
import com.hatshop.server.models.Product
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
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
@SpringBootTest(classes = HatShopApplication)
@WebAppConfiguration
class ProductRepositoryTest {

    @Autowired ProductRepository productRepository

    @Test
    public void testFindAllByCategories_Department_Id() throws Exception {
        Page<Product> productsPage = productRepository.findPageByCategories_Department_Id(2, new PageRequest(0, 50))

        assertEquals 8, productsPage.content.size()
    }

    @Test
    public void testFindAllByCategories_Id() {
        def productsPage = productRepository.findPageByCategories_Id(1, new PageRequest(0, 20));

        assertEquals 7, productsPage.content.size()
    }
}
