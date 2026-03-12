package com.ty.SmartInventoryManagementSystem.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
		@ExceptionHandler(ProductNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> handleProductNotFound(ProductNotFoundException ex){

			ResponseStructure<String> structure = new ResponseStructure<>();

			structure.setStatusCode(404);
			structure.setMessage("Product Not Found");
			structure.setData(ex.getMessage());

			return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
		}

		@ExceptionHandler(TransactionNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> handleTransactionNotFound(TransactionNotFoundException ex){

			ResponseStructure<String> structure = new ResponseStructure<>();

			structure.setStatusCode(404);
			structure.setMessage("Transaction Not Found");
			structure.setData(ex.getMessage());

			return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
		}
}
