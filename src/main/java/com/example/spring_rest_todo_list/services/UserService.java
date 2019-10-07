package com.example.spring_rest_todo_list.services;

import com.example.spring_rest_todo_list.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    User findUserByUsername(String name);

    List<User> findAllUsers();

    User saveUser(User user);

    void deleteUserById(Long id);

    User updateUser(User user);
}
