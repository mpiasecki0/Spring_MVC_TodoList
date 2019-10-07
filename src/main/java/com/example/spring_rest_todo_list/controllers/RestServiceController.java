package com.example.spring_rest_todo_list.controllers;

import com.example.spring_rest_todo_list.model.TodoList;
import com.example.spring_rest_todo_list.services.TodoListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestServiceController.BASE_URL)
public class RestServiceController {

    public static final String BASE_URL = "/api";

    private final TodoListService todoListService;


    public RestServiceController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping
    public List<TodoList> getAllTodos(){
        return todoListService.findAllTodoLists();
    }

    @GetMapping("/{id}")
    public TodoList getTodoById(@PathVariable Long id){
        return todoListService.findListById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoList createTodo(TodoList list){
        return todoListService.saveList(list);
    }

    @DeleteMapping
    public String deleteTodoByObject(TodoList todoList){
        // can also return void obviously
        return todoListService.deleteListByObject(todoList);
    }

    @DeleteMapping("/{id}")
    public String deleteTodoByObject(@PathVariable Long id){
        // can be void...
        return todoListService.deleteListById(id);
    }

    @PutMapping
    public TodoList updateTodo(TodoList list){
        // does the same thing as POST
        return todoListService.updateList(list);
    }

}
