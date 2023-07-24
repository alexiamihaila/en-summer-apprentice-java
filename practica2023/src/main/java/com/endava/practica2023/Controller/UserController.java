package com.endava.practica2023.Controller;

import com.endava.practica2023.Domain.User;
import com.endava.practica2023.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/api/users1")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
