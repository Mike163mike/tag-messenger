package com.mike.tagmessenger.mapper;

import com.mike.tagmessenger.dto.MessageDto;
import com.mike.tagmessenger.model.Message;
import org.mapstruct.Mapper;

@Mapper
public interface MessageMapper {

    MessageDto map(Message message);

    Message map(MessageDto messageDto);
}
