package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.AbstractTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;

class UserControllerTest extends AbstractTest {

    @Test
    void deleteUserWhenRequestIsOk() {

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
                .assertThat().contentType(ContentType.TEXT);
    }

    @Test
    void deleteUserWhenRequestIsBad() {

        String username = "Fry";
        String password = "100";

        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .delete("/user/Bender")
                .then()
                .statusCode(403)
                .assertThat().contentType(ContentType.TEXT)
                .assertThat()
                .body(containsString("User should be deleted only by himself"));
    }
}