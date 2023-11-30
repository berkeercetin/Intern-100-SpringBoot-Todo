package com.authAngular.tutorial.authAngular.api.controllers;

import com.authAngular.tutorial.authAngular.businness.abstracts.UserService;
import com.authAngular.tutorial.authAngular.config.UserAuthProvider;
import com.authAngular.tutorial.authAngular.dto.CredentialsDto;
import com.authAngular.tutorial.authAngular.dto.SignUpDto;
import com.authAngular.tutorial.authAngular.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class AuthController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    AuthController(UserService userService,UserAuthProvider userAuthProvider){
        this.userService=userService;
        this.userAuthProvider=userAuthProvider;
    }
    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserDto> register (@RequestBody SignUpDto signUpDto){
        UserDto user = userService.register(signUpDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.created(URI.create("/users/"+user.getId())).body(user);
    }
}
