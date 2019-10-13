package com.example.spring_rest_todo_list.controllers;

import com.example.spring_rest_todo_list.model.User;
import com.example.spring_rest_todo_list.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String loginPage(){
        // uses Spring Sec. default naming like name="username"/"password" in loginForm
        return "login";
    }

    @RequestMapping("/register")
    public String registerUser(Model model){
        // "prepare" the page with an empty Object for POST
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid User user, Errors errors){
        // data gets validated and posted onto the "empty/prepared" Object from GET method
        if(errors.hasErrors())
        {
            return "register";
        }else
            {
            User savedUser = userService.saveUser(user);
            return "redirect:/index";
        }
    }
}
