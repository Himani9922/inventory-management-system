package com.ty.SmartInventoryManagementSystem.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SmartInventoryManagementSystem.Entity.Product;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Repository.ProductRepo;
import com.ty.SmartInventoryManagementSystem.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {

		Product savedProduct = productRepo.save(product);

		ResponseStructure<Product> rs = new ResponseStructure<>();
		rs.setData(savedProduct);
		rs.setMessage("Product Saved Successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());
		System.out.println("Saving product: " + product.getProdName());
		return new ResponseEntity<>(rs, HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> getProductById(Long id) {

		Optional<Product> product = productRepo.findById(id);

		ResponseStructure<Product> rs = new ResponseStructure<>();

		if (product.isPresent()) {

			rs.setData(product.get());
			rs.setMessage("Product Found");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Product Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {

		List<Product> productList = productRepo.findAll();

		ResponseStructure<List<Product>> rs = new ResponseStructure<>();
		rs.setData(productList);
		rs.setMessage("All Products Retrieved");
		rs.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {

		Optional<Product> existingProduct = productRepo.findById(product.getProdId());

		ResponseStructure<Product> rs = new ResponseStructure<>();

		if (existingProduct.isPresent()) {

			Product updatedProduct = productRepo.save(product);

			rs.setData(updatedProduct);
			rs.setMessage("Product Updated Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Product Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteProduct(Long id) {

		Optional<Product> product = productRepo.findById(id);

		ResponseStructure<String> rs = new ResponseStructure<>();

		if (product.isPresent()) {

			productRepo.delete(product.get());

			rs.setData("Deleted");
			rs.setMessage("Product Deleted Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Product Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}
}