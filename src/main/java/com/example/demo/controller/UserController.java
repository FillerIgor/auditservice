package com.example.demo.controller;

import com.example.demo.entity.hibernate.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final com.example.demo.service.jooq.UserService jooqUserService;

    @GetMapping("/")
    private Flux<org.jooq.User> getUsers() {
        return Flux.fromStream(jooqUserService.getUsers().stream());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Mono<User> getUser(@PathVariable String uuid) {
        return Mono.justOrEmpty(userService.getUserById(UUID.fromString(uuid)));
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
