package com.example.demo.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @ManyToMany
    @JoinTable(name = , joinColumns = )
    private List<Organisation> organisation;
}
