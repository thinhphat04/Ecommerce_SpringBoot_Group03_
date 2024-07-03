package com.phat.e.project.Service;

import com.phat.e.project.Entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category getOneCategory(String id);
    Category createCategory(Category category);
    Category updateCategory(String id, Category updatedCategory);
    boolean deleteCategory(String id);
}
