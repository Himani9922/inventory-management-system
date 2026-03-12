package com.ty.SmartInventoryManagementSystem.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SmartInventoryManagementSystem.Entity.Category;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Repository.CategoryRepo;
import com.ty.SmartInventoryManagementSystem.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public ResponseEntity<ResponseStructure<Category>> saveCategory(Category category) {

		Category savedCategory = categoryRepo.save(category);

		ResponseStructure<Category> rs = new ResponseStructure<>();
		rs.setData(savedCategory);
		rs.setMessage("Category Added Successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());

		return new ResponseEntity<>(rs, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Category>> getCategoryById(Long id) {

		Optional<Category> category = categoryRepo.findById(id);

		ResponseStructure<Category> rs = new ResponseStructure<>();

		if (category.isPresent()) {

			rs.setData(category.get());
			rs.setMessage("Category Found");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		else {

			rs.setData(null);
			rs.setMessage("Category Not Found");
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());

			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Category>>> getAllCategories() {

		List<Category> categoryList = categoryRepo.findAll();

		ResponseStructure<List<Category>> rs = new ResponseStructure<>();
		rs.setData(categoryList);
		rs.setMessage("All Categories Retrieved");
		rs.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Category>> updateCategory(Category category) {

		Optional<Category> existingCategory = categoryRepo.findById(category.getCategoryId());

		ResponseStructure<Category> rs = new ResponseStructure<>();

		if (existingCategory.isPresent()) {

			Category updatedCategory = categoryRepo.save(category);

			rs.setData(updatedCategory);
			rs.setMessage("Category Updated Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		else {

			rs.setData(null);
			rs.setMessage("Category Not Found");
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());

			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteCategory(Long id) {

		Optional<Category> category = categoryRepo.findById(id);

		ResponseStructure<String> rs = new ResponseStructure<>();

		if (category.isPresent()) {

			categoryRepo.delete(category.get());

			rs.setData("Deleted");
			rs.setMessage("Category Deleted Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		else {

			rs.setData(null);
			rs.setMessage("Category Not Found");
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());

			return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
		}
	}
}