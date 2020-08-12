package com.hatshop.server.controllers

import com.hatshop.server.HatShopApplication
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.hamcrest.Matchers.*
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

/**
 * Test for DepartmentController
 * Created by luis on 7/9/15.
 */
//@RunWith(SpringJUnit4ClassRunner)
@SpringBootTest(classes = HatShopApplication)
@WebAppConfiguration
class DepartmentControllerTest {

    @Autowired
    WebApplicationContext wac

    MockMvc mmvc

    @BeforeEach
    void setUp() {
        mmvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }
    @Test
    void testDepartmentProducts() throws Exception {
        mmvc.perform(get("/departments/2/products").accept(APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath('content', hasSize(8)))
                .andExpect(jsonPath('content[0].id', is(8)))
                .andExpect(jsonPath('content[0].description', startsWith("Uniform Chauffeur Cap.")))
    }
}
