package com.ty.SmartInventoryManagementSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.SmartInventoryManagementSystem.Entity.Product;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;

public interface ProductService {
	ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);
	
	ResponseEntity<ResponseStructure<Product>> getProductById(Long id);
	
	ResponseEntity<ResponseStructure<List<Product>>> getAllProducts();
	
	ResponseEntity<ResponseStructure<Product>> updateProduct(Product Product);
	
	ResponseEntity<ResponseStructure<String>> deleteProduct(Long id);
}
