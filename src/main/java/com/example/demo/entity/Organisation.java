package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Organisation {

    @ManyToMany
    private List<User> user;
}
