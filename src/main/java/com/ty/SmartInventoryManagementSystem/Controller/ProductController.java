package com.ty.SmartInventoryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SmartInventoryManagementSystem.Entity.Product;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product){
		return productService.saveProduct(product);
	}
	 
	@GetMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }
	@GetMapping
	    public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
	        return productService.getAllProducts();
	    }

	@PutMapping
	  public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
	        return productService.updateProduct(product);
	    }

	@DeleteMapping("/{id}")
	  public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable Long id) {
	        return productService.deleteProduct(id);
	    }
}
