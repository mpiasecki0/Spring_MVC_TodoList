package com.example.spring_rest_todo_list.services;

import com.example.spring_rest_todo_list.model.TodoList;

import java.util.List;

public interface TodoListService {

    TodoList findListById(Long id);

    List<TodoList> findAllTodoLists();

    TodoList saveList(TodoList list);

    String deleteListByObject(TodoList list);

    String deleteListById(Long id);

    TodoList updateList(TodoList list);
}
