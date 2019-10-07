package com.example.spring_rest_todo_list.repositories;

import com.example.spring_rest_todo_list.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
}
