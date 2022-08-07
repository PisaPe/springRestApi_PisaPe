package com.example.chiquita.controllers;

import com.example.chiquita.requests.RegisterRequest;
import com.example.chiquita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> registerUser(@RequestBody @Valid RegisterRequest request) {
        userService.saveUser(request);
        // servisa ktera nam zaregistruje uzivatele

        return ResponseEntity.ok().build();
    }
}
