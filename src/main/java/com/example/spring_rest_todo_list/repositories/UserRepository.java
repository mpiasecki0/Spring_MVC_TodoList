package com.example.spring_rest_todo_list.repositories;

import com.example.spring_rest_todo_list.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);   // added specific method which isn't defined by default in the Interface (needed for Spring Security)
}
