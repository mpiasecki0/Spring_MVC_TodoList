package com.example.spring_rest_todo_list.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true, nullable = false)
    @NotEmpty(message = "Username field is empty.")
    @Size(min = 6, max = 16, message = "Username should be between 6 to 16 characters long.")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "Password field is empty!")
    @Size(min = 6, max = 60, message = "Your Password should have a minimum of 6 characters.")
    private String password;

    private String role = "USER";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
