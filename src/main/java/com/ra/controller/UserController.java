package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    public String user(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users",users);
        return "user";
    }

    @RequestMapping("/add-user")
    public String add(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "add-user";
    }
    @RequestMapping("/save-user")
    public String save(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/user";
    }
}
