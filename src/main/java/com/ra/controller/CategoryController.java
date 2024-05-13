package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/category")
    public String index(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "index-category";
    }

    @RequestMapping("/add-category")
    public String add(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "add-category";
    }

    @RequestMapping("/save-category")
//    public String save(HttpServletRequest request){
//        // laays duwoc du lieu tu from
//        //cach 1
////        String name = request.getParameter("name");
////        String description = request.getParameter("description");
////        String status = request.getParameter("status");
////        System.out.println(name);
////        System.out.println(description);
////        System.out.println(status);
//
//        return "save-category";
//    }
//    public String save(
//            @RequestParam("name") String name,
//            @RequestParam("description") String description,
//            @RequestParam("status") String status
//    ){
//        System.out.println(name);
//        System.out.println(description);
//        System.out.println(status);
//        return "save-category";
//    }
    // cach 3
    public String save(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        if(categoryService.add(category)){
            redirectAttributes.addFlashAttribute("success","Thêm mới thành công");
            return "redirect:/category";
        }
        return "add-category";
    }
    @GetMapping("/edit-category/{id}")
    public String edit(@PathVariable Integer id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "edit-category";
    }
    @PostMapping("/edit-category/{id}")
    public String update(@ModelAttribute("category") Category category,RedirectAttributes redirectAttributes){
        if (categoryService.update(category)){
            redirectAttributes.addFlashAttribute("success","Cập nhật thành công");
            return "redirect:/category";
        }
        return "add-category";
    }
    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        if (categoryService.delete(id)){
            redirectAttributes.addFlashAttribute("success","Xoá thành công!");
            return "redirect:/category";
        }
        redirectAttributes.addFlashAttribute("success","Xoá thất bại!");
        return "redirect:/category";
    }
}
