package com.example.demo.config;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {

    @Autowired
    private DSLContext context;

    public void m1(){

    }
}
