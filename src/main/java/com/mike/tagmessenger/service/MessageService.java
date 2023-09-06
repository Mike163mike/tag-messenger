package com.mike.tagmessenger.service;

import com.mike.tagmessenger.model.Message;
import org.springframework.data.domain.Page;

public interface MessageService {

    void createMessage(Message message);

    Page<Message> getMessagesByHashtag(String hashtag);

    Page<Message> getAllMessages();
}
