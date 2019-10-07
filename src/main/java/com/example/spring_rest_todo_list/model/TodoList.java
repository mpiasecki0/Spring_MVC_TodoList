package com.example.spring_rest_todo_list.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoList {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String message;
    private String username;

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
