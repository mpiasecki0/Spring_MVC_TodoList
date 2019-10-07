package com.example.spring_rest_todo_list;

import com.example.spring_rest_todo_list.model.TodoList;
import com.example.spring_rest_todo_list.model.User;
import com.example.spring_rest_todo_list.repositories.TodoListRepository;
import com.example.spring_rest_todo_list.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitH2Data implements CommandLineRunner {

    private final TodoListRepository todoListRepository;
    private final UserRepository userRepository;

    public InitH2Data(TodoListRepository todoListRepository, UserRepository userRepository) {
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Creating POJO's...");

        TodoList t1 = new TodoList();
        t1.setId(1);
        t1.setMessage("Buy Eggs and Milk");
        t1.setUsername("Mom");
        todoListRepository.save(t1);

        TodoList t2 = new TodoList();
        t2.setId(2);
        t2.setMessage("Do my homework");
        t2.setUsername("Brad");
        todoListRepository.save(t2);

        TodoList t3 = new TodoList();
        t3.setId(3);
        t3.setMessage("Fill up gasoline");
        t3.setUsername("Dad");
        todoListRepository.save(t3);

        System.out.println("DB Setup done, there is a total of "+ todoListRepository.count()+" Objects in  the Database.");
        /**
        User u1 = new User();
        u1.setUsername("john");
        u1.setPassword("123");
        u1.setRole("USER");
        userRepository.save(u1);

        User u2 = new User();
        u2.setUsername("admin");
        u2.setPassword("secret");
        u2.setRole("ADMIN");
        userRepository.save(u2);

        System.out.println("Created Users for DB...");**/
    }

}
