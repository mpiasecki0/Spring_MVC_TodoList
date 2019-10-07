package com.example.spring_rest_todo_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.SchemaOutputResolver;

@SpringBootApplication
public class SpringRestTodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestTodoListApplication.class, args);
    }       // todo: add admin role for h2/ add USER ROLE when registering/ and  BCRYPT for password encryption :)
    // todo: test unique FIELD on USER... check with autogen if its unique is working
}
