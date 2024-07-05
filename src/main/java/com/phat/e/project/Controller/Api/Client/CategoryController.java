package com.phat.e.project.Controller.Api.Client;

import com.phat.e.project.Entity.Category;
import com.phat.e.project.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable String id) {
        return categoryService.getOneCategory(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable String id, @RequestBody Category updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable String id) {
        return categoryService.deleteCategory(id);
    }
}
