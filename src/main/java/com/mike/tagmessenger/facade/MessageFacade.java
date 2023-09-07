package com.mike.tagmessenger.facade;

import com.mike.tagmessenger.dto.MessageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageFacade {

    void createMessage(MessageDto messageDto);

    Page<MessageDto> getMessagesByHashtag(String hashtag, Pageable pageable);

    Page<MessageDto> getAllMessages(Pageable pageable);


}
