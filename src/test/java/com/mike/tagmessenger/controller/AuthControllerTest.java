package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.AbstractTest;
import com.mike.tagmessenger.dto.UserRegDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

@RunWith(MockitoJUnitRunner.class)
class AuthControllerTest extends AbstractTest {
    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    void createNewUser() {

        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        var user = new UserRegDto("TestUser100", "300");

        RestAssured
                .given()
                .when()
                .body(user)
                .post("/auth")
                .then()
                .statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("username", Matchers.equalTo("TestUser100"));
    }
}