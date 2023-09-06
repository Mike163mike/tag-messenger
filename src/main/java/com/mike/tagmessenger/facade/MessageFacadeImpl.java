package com.mike.tagmessenger.facade;

import com.mike.tagmessenger.dto.MessageDto;
import com.mike.tagmessenger.mapper.MessageMapper;
import com.mike.tagmessenger.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageFacadeImpl implements MessageFacade {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Override
    public void createMessage(MessageDto messageDto) {
        var newMessage = messageMapper.map(messageDto);
        messageService.createMessage(newMessage);
    }

    @Override
    public Page<MessageDto> getMessagesByHashtag(String hashtag) {
        return null;
    }

    @Override
    public Page<MessageDto> getAllMessages() {
        return null;
    }
}
