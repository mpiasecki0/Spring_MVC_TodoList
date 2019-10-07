package com.example.spring_rest_todo_list.controllers;

        import com.example.spring_rest_todo_list.model.User;
        import com.example.spring_rest_todo_list.services.UserService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

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
        // "prepare" the page with an empty Object
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(User user){
        // data gets posted onto that "prepared" Object
        User savedUser = userService.saveUser(user);
        return "redirect:/index";
    }
}
