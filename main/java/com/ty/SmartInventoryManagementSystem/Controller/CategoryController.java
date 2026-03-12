package com.ty.SmartInventoryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ty.SmartInventoryManagementSystem.Entity.Category;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Category>> saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Category>> getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Category>>> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Category>> updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}