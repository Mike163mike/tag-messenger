package com.mike.tagmessenger.service;

import com.mike.tagmessenger.exception.AppException;
import com.mike.tagmessenger.model.Message;
import com.mike.tagmessenger.repository.MessageRepository;
import com.mike.tagmessenger.repository.UserRepository;
import com.mike.tagmessenger.security.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        var username = securityContextService.getUserName();
        var user = userRepository.findUserByUsername(username);
        if (!message.getHashtag().startsWith("#")) {
            var hashtag = "#" + message.getHashtag();
            message.setHashtag(hashtag);
        }
        message.setPublisher(user);
        if (messageRepository.findByMessage(message.getMessage()) != null) {
            throw new AppException(String.format("Message: \" %s \" already published ", message.getMessage()),
                    HttpStatus.BAD_REQUEST);
        } else {
            messageRepository.save(message);
        }
    }

    @Override
    public Page<Message> getMessagesByHashtag(String hashtag, Pageable pageable) {
        return messageRepository.findAllByHashtagOrderByCreateTimeDesc(hashtag, pageable);
    }

    @Override
    public Page<Message> getAllMessages(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }
}
