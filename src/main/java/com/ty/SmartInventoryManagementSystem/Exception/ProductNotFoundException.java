package com.ty.SmartInventoryManagementSystem.Exception;

public class ProductNotFoundException extends RuntimeException{

		String message = "Product not found";

		public ProductNotFoundException() {}

		public ProductNotFoundException(String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;
		}

}

