package com.ra.model.service;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean add(Category category);
    Category findById(Integer id);
    Boolean update(Category category);
    Boolean delete(Integer id);
}
