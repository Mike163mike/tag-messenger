package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.dto.MessageDto;
import com.mike.tagmessenger.facade.MessageFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
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
//
//    @GetMapping
//    @Operation(summary = "Get pages of all my posts")
//    public ResponseEntity<Page<PostDto>> getAllMyPosts(@PageableDefault Pageable pageable) {
//        Page<PostDto> postDtos = postService.findAllPostsByPublisherId(postService.getMyId(),
//                        pageable)
//                .map(postMapper::map);
//        return ResponseEntity.ok(postDtos);
//    }
//
//    @GetMapping("/page")
//    @Operation(summary = "Get pages of all users posts i am follow .")
//    public ResponseEntity<Page<Post>> getCustomers(@RequestParam(defaultValue = "0") int page,
//                                                   @RequestParam(defaultValue = "10") int size) {
//
//        Page<Post> customerPage = postService.getAllPosts(page, size);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Page-Number", String.valueOf(customerPage.getNumber()));
//        headers.add("X-Page-Size", String.valueOf(customerPage.getSize()));
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(customerPage);
//    }
}
