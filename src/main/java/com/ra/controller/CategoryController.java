package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categorySeevice;
    @RequestMapping("/category")
    public String index(Model model){
        List<Category> categories = categorySeevice.getAll();
        model.addAttribute("categories",categories);
        return "index-category";
    }
}
