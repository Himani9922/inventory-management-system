package com.ty.SmartInventoryManagementSystem.Exception;

public class TransactionNotFoundException extends RuntimeException {

		String message = "Transaction not found";

		public TransactionNotFoundException() {}

		public TransactionNotFoundException(String message) {
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;
		}
}
