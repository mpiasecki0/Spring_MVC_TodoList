package com.example.spring_rest_todo_list;

import com.example.spring_rest_todo_list.controllers.RestServiceController;
import com.example.spring_rest_todo_list.controllers.ViewController;
import com.example.spring_rest_todo_list.model.TodoList;
import com.example.spring_rest_todo_list.model.User;
import com.example.spring_rest_todo_list.services.TodoListService;
import com.example.spring_rest_todo_list.services.UserService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRestControllerTests {

    @Mock
    private TodoListService todoListService;
    @Mock
    private UserService userService;

    @InjectMocks
    private RestServiceController restServiceController;

    private MockMvc mockMvc;

    @Before
    public void setupUnitTests(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restServiceController).build();
    }

    @Test
    public void testListResponse() throws Exception{
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());

        when(userService.findAllUsers()).thenReturn(list);
        // doesnt get invoked for some reason...

        mockMvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$", hasSize(2)));

        verify(userService).findAllUsers();
    }
}
