package com.mike.tagmessenger.controller;

import com.mike.tagmessenger.dto.UserRegDto;
import com.mike.tagmessenger.facade.UserFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@Tag(name = "Registration users", description = "Registration API. Endpoints for registration new users.")
@AllArgsConstructor
public class AuthController {

    private final UserFacade userFacade;

    @Operation(summary = "Registration new user by username and password.")
    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserRegDto userRegDto) {
        return ResponseEntity.ok(userFacade.createUser(userRegDto));
    }

    @GetMapping //=================================
    public String test() {
        return "test" + "====================";
    }
}