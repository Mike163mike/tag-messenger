package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.Specs;
import com.mike.tagmessenger.dto.MessageDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class MessageControllerTest {

    final String username = "Bender";
    final String password = "100";
    final MessageDto message = new MessageDto("Test message.", "#testTag");

    @Test
    void createMessage() {
        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .body(message)
                .post("/message")
                .then()
                .statusCode(200)
                .assertThat().contentType(ContentType.JSON);
    }

    @Test
    void getMessagesByHashtag() {

        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .get("/message/#testTag")
                .then()
                .statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("message", Matchers.equalTo("Test message."),
                        "hashtaqg", Matchers.equalTo("#testTag"));
    }

    @Test
    void getAllMessages() {
        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .get("/message")
                .then()
                .statusCode(200)
                .assertThat().contentType(ContentType.JSON)
                .body("message", Matchers.equalTo("Test message."),
                        "hashtaqg", Matchers.equalTo("#testTag"));
    }
}