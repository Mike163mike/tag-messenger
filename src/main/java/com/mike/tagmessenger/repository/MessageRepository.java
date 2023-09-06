package com.mike.tagmessenger.repository;

import com.mike.tagmessenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    Message findByMessage(String message);
}
