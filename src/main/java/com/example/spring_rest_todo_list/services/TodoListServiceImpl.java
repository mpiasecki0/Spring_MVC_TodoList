package com.example.spring_rest_todo_list.services;

import com.example.spring_rest_todo_list.model.TodoList;
import com.example.spring_rest_todo_list.repositories.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList findListById(Long id) {
        return todoListRepository.findById(id).get();
    }

    @Override
    public List<TodoList> findAllTodoLists() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoList saveList(TodoList list) {
        return todoListRepository.save(list);
    }

    @Override
    public String deleteListByObject(TodoList list) {
        todoListRepository.delete(list);
        return "Deleted "+list;
    }

    @Override
    public String deleteListById(Long id) {
        todoListRepository.deleteById(id);
        return "Deleted Todo with the ID Nr. "+id;
    }

    @Override
    public TodoList updateList(TodoList list) {
        return todoListRepository.save(list);
    }
}
