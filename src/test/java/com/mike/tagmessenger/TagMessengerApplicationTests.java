package com.mike.tagmessenger;

import com.mike.tagmessenger.controller.AuthController;
import com.mike.tagmessenger.controller.MessageController;
import com.mike.tagmessenger.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TagMessengerApplicationTests extends AbstractTest {

    @Autowired
    private AuthController authController;

    @Autowired
    private MessageController messageController;
    @Autowired
    private UserController userController;

    @Test
    void contextLoadsAuth() {
        assertThat(authController).isNotNull();
    }

    @Test
    void contextLoadsMessage() {
        assertThat(messageController).isNotNull();
    }

    @Test
    void contextLoadsUser() {
        assertThat(userController).isNotNull();
    }
}
