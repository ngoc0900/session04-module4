package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.UserService;
import com.ra.model.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/user")
    public String user(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users",users);
        return "user";
    }
}
