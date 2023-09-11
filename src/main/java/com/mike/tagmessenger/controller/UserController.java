package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.facade.UserFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@Tag(name = "Users management", description = "The API for menage users. The endpoint for delete users.")
@SecurityRequirement(name = "BasicAuth")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @DeleteMapping("/{username}")
    @Operation(summary = "Delete user by username.")
    private ResponseEntity<?> deleteUser(@PathVariable String username) {
        userFacade.deleteUser(username);
        return ResponseEntity.ok(String.format("User %s was deleted successfully.", username));
    }
}
