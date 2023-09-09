package com.mike.tagmessenger.repository;

import com.mike.tagmessenger.model.Message;
import com.mike.tagmessenger.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    Message findByMessage(String message);
    List<Message> findMessageByPublisher(User publisher);
    Page<Message> findAllByHashtagOrderByCreateTimeDesc(String hashtag, Pageable pageable);
    @NonNull
    Page<Message> findAll(@NonNull Pageable pageable);
}
