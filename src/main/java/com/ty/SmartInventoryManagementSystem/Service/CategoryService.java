package com.ty.SmartInventoryManagementSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.SmartInventoryManagementSystem.Entity.Category;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;

public interface CategoryService {
	ResponseEntity<ResponseStructure<Category>> saveCategory(Category category);
	
	ResponseEntity<ResponseStructure<Category>> getCategoryById(Long id);
	
	ResponseEntity<ResponseStructure<List<Category>>> getAllCategories();
	
	ResponseEntity<ResponseStructure<Category>> updateCategory(Category category);
	
	ResponseEntity<ResponseStructure<String>> deleteCategory(Long id);
}
