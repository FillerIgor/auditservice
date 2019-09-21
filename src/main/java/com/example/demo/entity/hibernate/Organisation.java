package com.example.demo.entity.hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Organisation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name ="name")
    private String name;

    @ManyToMany
    private List<User> user;
}
