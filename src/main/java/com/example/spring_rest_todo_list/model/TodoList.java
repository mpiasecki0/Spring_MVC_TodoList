package com.example.spring_rest_todo_list.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class TodoList {

    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @Size(min = 1, max = 300, message = "The message should have at least 1 and a maximum of 300 characters")
    private String message;
    @Size(min = 1, max = 300, message = "Please tell us who left the message")
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
