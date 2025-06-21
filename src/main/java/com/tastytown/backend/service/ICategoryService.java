package com.tastytown.backend.service;

import java.util.List;


import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;

public interface ICategoryService {
    /**
         *<h3> It Creates a Category Object by category name</h3>
     */
    Category saveCategory(CategoryRequestDTO requestDTO);

    List<Category> getAll();

    Category getCategoryById(String categoryid);

    Category updateCategoryById(String categoryid, CategoryRequestDTO requestDTO);
     
    void deleteCategoryById(String categoryid);

    
}
