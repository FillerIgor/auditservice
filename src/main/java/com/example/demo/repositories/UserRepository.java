package com.example.demo.repositories;

import com.example.demo.entity.hibernate.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
