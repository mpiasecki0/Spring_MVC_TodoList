package com.example.spring_rest_todo_list;

import com.example.spring_rest_todo_list.controllers.RestServiceController;
import com.example.spring_rest_todo_list.controllers.ViewController;
import com.example.spring_rest_todo_list.model.TodoList;
import com.example.spring_rest_todo_list.model.User;
import com.example.spring_rest_todo_list.services.TodoListService;
import com.example.spring_rest_todo_list.services.UserService;
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
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringViewControllerTests {

    @Mock
    private TodoListService todoListService;
    @Mock
    private UserService userService;

    @InjectMocks
    private ViewController viewController;

    private MockMvc mockMvc;

    @Before
    public void setupUnitTests(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(viewController).build();
    }

    @Test
    public void testTableView() throws Exception{
        List<TodoList> list = new ArrayList<>();
        list.add(new TodoList());
        list.add(new TodoList());

        when(todoListService.findAllTodoLists()).thenReturn(list);

        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("/home/todoListView"))
                .andExpect(model().attribute("todo", hasSize(2)));
    }

    @Test
    public void testParamMethod() throws Exception{
        Long id = 1L;

        when(todoListService.findListById(id)).thenReturn(new TodoList());

        mockMvc.perform(get("/home/"+id))
                .andExpect(status().isOk())
                .andExpect(view().name("/home/todoListView"))
                .andExpect(model().attribute("todo", instanceOf(TodoList.class)));
    }

    @Test
    public void testVoidMethod() throws Exception{
        Long id = 1L;

        mockMvc.perform(get("/home/delete/"+id))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/home"));

        verify(todoListService, times(1)).deleteListById(id);
    }
}
