package com.mike.tagmessenger.facade;

import com.mike.tagmessenger.dto.MessageDto;
import org.springframework.data.domain.Page;

public interface MessageFacade {

    void createMessage(MessageDto messageDto);

    Page<MessageDto> getMessagesByHashtag(String hashtag);

    Page<MessageDto> getAllMessages();


}
