package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
    //todo check whether it's possible to use UUID
    private String id;
    private String firstName;
    private String lastName;
}
