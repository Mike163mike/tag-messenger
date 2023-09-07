package com.mike.tagmessenger.service;

import com.mike.tagmessenger.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {

    void createMessage(Message message);

    Page<Message> getMessagesByHashtag(String hashtag, Pageable pageable);

    Page<Message> getAllMessages(Pageable pageable);
}
