package com.ty.SmartInventoryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SmartInventoryManagementSystem.Entity.StockTransaction;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Service.StockTransactionService;

@RestController
@RequestMapping("/transactions")
public class StockTransactionController {
	
	@Autowired
	private StockTransactionService stockTransactionService;
	
	@PostMapping("/save")
    public ResponseEntity<ResponseStructure<StockTransaction>> createTransaction(@RequestBody StockTransaction transaction) {

        return stockTransactionService.createTransaction(transaction);
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<ResponseStructure<StockTransaction>> getTransactionById(@PathVariable Long id) {

        return stockTransactionService.getTransactionById(id);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<ResponseStructure<List<StockTransaction>>> getAllTransactions() {

        return stockTransactionService.getAllTransactions();
    }

    @GetMapping("/getTransProduct/{productId}")
    public ResponseEntity<ResponseStructure<List<StockTransaction>>> getTransactionsByProduct(
            @PathVariable Long productId) {

        return stockTransactionService.getTransactionsByProduct(productId);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteTransaction(
            @PathVariable Long id) {

        return stockTransactionService.deleteTransaction(id);
    }
}


