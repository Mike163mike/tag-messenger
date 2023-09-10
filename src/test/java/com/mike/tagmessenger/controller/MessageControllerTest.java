package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.AbstractTest;
import com.mike.tagmessenger.dto.MessageDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.containsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MessageControllerTest extends AbstractTest {

    final String username = "Bender";
    final String password = "100";
    final MessageDto message = new MessageDto("Test message.", "#testTag");

    @Test
    @Order(1)
    void createMessageWhenRequestIsOk() {
        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .body(message)
                .post("/message")
                .then()
                .statusCode(200)
                .assertThat().contentType(ContentType.TEXT)
                .assertThat()
                .body(containsString("Message created."));
    }

    @Test
    @Order(2)
    void createMessageWhenRequestIsBad() {
        Specs.instalSpec(Specs.requestSpec("http://localhost", 8080), Specs.responseSpec());

        RestAssured
                .given()
                .auth().basic(username, password)
                .when()
                .body(message)
                .post("/message")
                .then()
                .statusCode(400)
                .assertThat().contentType(ContentType.TEXT)
                .assertThat()
                .body(containsString("Message: \" Test message. \" already published."));
    }

    @Test
    @Order(3)
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
                .assertThat()
                .body(containsString("Test message."));
    }

    @Test
    @Order(4)
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
                .assertThat()
                .body(containsString("Test message."),
                        containsString("Bender the best! Kiss my shiny metal a**!"),
                        containsString("Remember me!!!"),
                        containsString("I love Leela! Any Leela!"));
    }
}