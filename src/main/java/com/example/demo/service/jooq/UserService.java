package com.example.demo.service.jooq;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.User;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.entity.jooq.User.USER;

@Service("jooqUserService")
@RequiredArgsConstructor
public class UserService {

    private final DSLContext dsl;

    public List<User> getUsers() {
        return dsl.select().from("SELECT * FROM USER").fetch().into(User.class);
    }
}
