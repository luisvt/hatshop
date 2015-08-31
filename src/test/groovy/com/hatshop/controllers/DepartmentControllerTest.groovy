package com.hatshop.controllers

import com.hatshop.HatshopApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
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
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = HatshopApplication)
@WebAppConfiguration
public class DepartmentControllerTest {

    @Autowired
    WebApplicationContext wac

    MockMvc mmvc

    @Before
    public void setUp() {
        mmvc = MockMvcBuilders.webAppContextSetup(wac).build()
    }
    @Test
    public void testDepartmentProducts() throws Exception {
        mmvc.perform(get("/departments/2/products").accept(APPLICATION_JSON))
                .andExpect(jsonPath('content', hasSize(8)))
                .andExpect(jsonPath('content[1].id', is(24)))
                .andExpect(jsonPath('content[1].description', startsWith("The Parkhurst SunGuard line of headwear")))
    }
}