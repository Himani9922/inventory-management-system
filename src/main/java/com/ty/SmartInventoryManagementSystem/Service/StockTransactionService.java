package com.ty.SmartInventoryManagementSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.SmartInventoryManagementSystem.Entity.StockTransaction;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;

public interface StockTransactionService {
	 ResponseEntity<ResponseStructure<StockTransaction>> createTransaction(StockTransaction transaction);
	 
	 ResponseEntity<ResponseStructure<StockTransaction>> getTransactionById(Long id);
	 
	 ResponseEntity<ResponseStructure<List<StockTransaction>>> getAllTransactions();
	 
	 ResponseEntity<ResponseStructure<List<StockTransaction>>> getTransactionsByProduct(Long productId);
	 
	 ResponseEntity<ResponseStructure<String>> deleteTransaction(Long id);
}
