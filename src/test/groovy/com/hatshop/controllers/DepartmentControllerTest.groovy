package com.hatshop.controllers

import com.hatshop.HatshopApplication
import com.jayway.restassured.RestAssured
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import static com.jayway.restassured.RestAssured.when

/**
 * Test for DepartmentController
 * Created by luis on 7/9/15.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = HatshopApplication)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class DepartmentControllerTest {
    @Value('${local.server.port}')   // 6
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }
    @Test
    public void testDepartmentProducts() throws Exception {
        when().get('departments/2/products').body
    }
}