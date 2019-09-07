package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Mono<User> getUser(@PathVariable String uuid) {
        return userService.getUserById(UUID.fromString(uuid));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String getInfo() {
        return "info";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private UUID createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /*@ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    private UUID updateUser(){

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    private UUID deleteUser(){

    }*/

}
