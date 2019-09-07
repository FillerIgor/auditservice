package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Organisation {

    @ManyToMany
    private List<User> user;
}
