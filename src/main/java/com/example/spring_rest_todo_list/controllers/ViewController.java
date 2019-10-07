package com.example.spring_rest_todo_list.controllers;

import com.example.spring_rest_todo_list.model.TodoList;
import com.example.spring_rest_todo_list.services.TodoListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ViewController {

    private TodoListService todoListService;

    public ViewController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @RequestMapping("/index")
    public String homePage(){
        return "index";
    }

    @RequestMapping("/home")
    public String showTodoLists(Model model){
        List<TodoList> list = todoListService.findAllTodoLists();
        model.addAttribute("todo", list);
        return "todoListView";
    }

    @RequestMapping("/home/{id}")
    public String showTodoListById(@PathVariable Long id, Model model){
        TodoList todo = todoListService.findListById(id);
        model.addAttribute("todo", todo);
        return "todoListView";
    }

    @RequestMapping("/home/new")
    public String createTodoList(Model model){
        model.addAttribute("todo", new TodoList());
        return "createTodoList";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String saveOrUpdateTodoList(TodoList todo){
        TodoList savedTodo = todoListService.saveList(todo);
        return "redirect:/home";
    }

    @RequestMapping(value = "/home/edit/{id}")
    public String updateTodoList(@PathVariable Long id, Model model){
        TodoList updateTodo = todoListService.findListById(id);
        model.addAttribute("todo", updateTodo);
        return "editTodoList";
    }

    @RequestMapping(value = "/home/delete/{id}")
    public String deleteTodoListById(@PathVariable Long id){
        todoListService.deleteListById(id);
        return "redirect:/home";
    }
}
