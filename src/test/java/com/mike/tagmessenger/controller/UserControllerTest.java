package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.Specs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

class UserControllerTest {

    @Test
    void deleteUser() {

        String username = "Bender";
        String password = "100";

        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .delete("/user/Bender")
                .then()
                .statusCode(200)
                .assertThat().contentType(ContentType.JSON);
    }
}