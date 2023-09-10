package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.AbstractTest;
import com.mike.tagmessenger.dto.UserRegDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class AuthControllerTest extends AbstractTest {

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