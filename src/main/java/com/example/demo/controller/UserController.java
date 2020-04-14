package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import jooq.tables.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    private Flux<UserData> getUsers() {
        return Flux.fromStream(userService.getUsers().stream());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{uuid}")
    private Mono<UserData> getUser(@PathVariable String uuid) {
        return Mono.justOrEmpty(userService.getUserById(UUID.fromString(uuid)));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/info")
    private String getInfo() {
        return "info";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private UUID createUser(@RequestBody UserDto user) {
        return userService.createUser(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    private UUID updateUser(@RequestBody UserDto user) {
        return userService.updateUser(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    private UUID deleteUser(@PathVariable String uuid) {
        return userService.deleteUserById(uuid);
    }

}
