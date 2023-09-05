package com.mike.tagmessenger.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/message")
@RestController
//@Tag(name = "Messages from users", description = "The API for creating and reading messages. The endpoints for
// creating messages and reading them all or by hashtag page by page.")
@AllArgsConstructor
public class MessageController {

}
