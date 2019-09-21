package com.example.demo.entity.jooq;

import lombok.Data;
import org.jooq.impl.TableImpl;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

public class User {

    public static final User USER = new User();

    private UUID id;
    private String firstName;
    private String lastName;
}
