package com.tastytown.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.entity.Category;
import com.tastytown.backend.exception.GlobalException;
import com.tastytown.backend.repository.CategoryRepository;
import com.tastytown.backend.service.ICategoryService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
private final CategoryRepository categoryrepository;
 

    public Category saveCategory(CategoryRequestDTO requestDTO) {
         var category = Category.builder()
                                .categoryName(requestDTO
                                .getCategoryName())
                                .build();
        return categoryrepository.save(category);

    }
    public List<Category> getAll() {
        return categoryrepository.findAll();
    }
    public Category getCategoryById(String categoryid) {
        return categoryrepository.findById(categoryid)
                .orElseThrow(() -> new GlobalException("Category not found with id: " + categoryid));
    }
   
    public Category updateCategoryById(String categoryid, CategoryRequestDTO requestDTO) {
        var existingCategory = getCategoryById(categoryid);
        existingCategory.setCategoryName(requestDTO.getCategoryName());
        return categoryrepository.save(existingCategory);

    }
    public void deleteCategoryById(String categoryid) {
       Category category = getCategoryById(categoryid);
        categoryrepository.delete(category);
    }
}
