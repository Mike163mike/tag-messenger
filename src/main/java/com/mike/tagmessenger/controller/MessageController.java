package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.dto.MessageDto;
import com.mike.tagmessenger.facade.MessageFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/message")
@RestController
@Tag(name = "Messages from users", description = "The API for creating and reading messages. The endpoints for " +
        "creating messages and reading them all or by hashtag page by page.")
@AllArgsConstructor
public class MessageController {

    private final MessageFacade messageFacade;

    @PostMapping
    @Operation(summary = "Create new message")
    public ResponseEntity<?> createMessage(@RequestBody MessageDto messageDto) {
        messageFacade.createMessage(messageDto);
        return ResponseEntity.ok("Message created.");
    }

    @GetMapping("/{hashtag}")
    @Operation(summary = "Get message pages by hashtag.")
    public ResponseEntity<Page<MessageDto>> getMessagesByHashtag(@PathVariable String hashtag,
                                                                 @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(messageFacade.getMessagesByHashtag(hashtag, pageable));
    }

    @GetMapping
    @Operation(summary = "Get all messages by page, one after one.")
    public ResponseEntity<Page<MessageDto>> getAllMessages(@PageableDefault(sort = "createTime",
            direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(messageFacade.getAllMessages(pageable));
    }
}
