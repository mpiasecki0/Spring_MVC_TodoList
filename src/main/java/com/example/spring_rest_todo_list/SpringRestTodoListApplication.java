package com.example.spring_rest_todo_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.SchemaOutputResolver;

@SpringBootApplication
public class SpringRestTodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestTodoListApplication.class, args);
    }       // todo: ADMIN role is useless atm, because of CustomUserDetails returning wrong GrantedAuthorities
    // todo: check inserting USER in initH2Data.java after constraint UNIQUE has been set
    // todo: add content that can only be seen by certain ROLE
}
