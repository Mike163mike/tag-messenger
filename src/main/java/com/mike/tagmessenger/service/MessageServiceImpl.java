package com.mike.tagmessenger.service;

import com.mike.tagmessenger.exception.AppException;
import com.mike.tagmessenger.model.Message;
import com.mike.tagmessenger.repository.MessageRepository;
import com.mike.tagmessenger.repository.UserRepository;
import com.mike.tagmessenger.security.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final SecurityContextService securityContextService;
    private final UserRepository userRepository;

    @Override
    public void createMessage(Message message) {
        var user = userRepository.findUserByUsername(securityContextService.getUserName());
        message.setPublisher(user);
        if (messageRepository.findByMessage(message.getMessage()) != null) {
            throw new AppException(String.format("Message: \" %s \" already published ", message),
                    HttpStatus.BAD_REQUEST);
        }else {
            messageRepository.save(message);
        }
    }

    @Override
    public Page<Message> getMessagesByHashtag(String hashtag) {
        return null;
    }

    @Override
    public Page<Message> getAllMessages() {
        return null;
    }
}
