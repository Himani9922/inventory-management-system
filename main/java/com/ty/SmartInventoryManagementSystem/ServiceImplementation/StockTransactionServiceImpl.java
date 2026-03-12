package com.ty.SmartInventoryManagementSystem.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SmartInventoryManagementSystem.Entity.Product;
import com.ty.SmartInventoryManagementSystem.Entity.StockTransaction;
import com.ty.SmartInventoryManagementSystem.Entity.TransactionType;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Repository.ProductRepo;
import com.ty.SmartInventoryManagementSystem.Repository.StockTransactionRepo;
import com.ty.SmartInventoryManagementSystem.Service.StockTransactionService;

@Service
public class StockTransactionServiceImpl implements StockTransactionService {

	@Autowired
	private StockTransactionRepo stockTransactionRepo;

	@Autowired
	private ProductRepo productRepo;

	@Override
	public ResponseEntity<ResponseStructure<StockTransaction>> createTransaction(StockTransaction transaction) {

		ResponseStructure<StockTransaction> rs = new ResponseStructure<>();

		Long productId = transaction.getProduct().getProdId();

		Optional<Product> optionalProduct = productRepo.findById(productId);

		if (optionalProduct.isPresent()) {

			Product product = optionalProduct.get();

			// Set transaction date automatically
			transaction.setTransactionDate(LocalDateTime.now());

			// Stock Logic
			if (transaction.getTransactionType() == TransactionType.IN) {
				product.setQuantity(product.getQuantity() + transaction.getQuantityChanged());
			} 
			else if (transaction.getTransactionType() == TransactionType.OUT) {

				if (product.getQuantity() < transaction.getQuantityChanged()) {
					rs.setData(null);
					rs.setMessage("Not enough stock available");
					rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
					return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
				}

				product.setQuantity(product.getQuantity() - transaction.getQuantityChanged());
			}

			productRepo.save(product);

			transaction.setProduct(product);

			StockTransaction savedTransaction = stockTransactionRepo.save(transaction);

			rs.setData(savedTransaction);
			rs.setMessage("Stock Transaction Created Successfully");
			rs.setStatusCode(HttpStatus.CREATED.value());

			return new ResponseEntity<>(rs, HttpStatus.CREATED);
		}

		rs.setData(null);
		rs.setMessage("Product not found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<StockTransaction>> getTransactionById(Long id) {

		ResponseStructure<StockTransaction> rs = new ResponseStructure<>();

		Optional<StockTransaction> transaction = stockTransactionRepo.findById(id);

		if (transaction.isPresent()) {

			rs.setData(transaction.get());
			rs.setMessage("Transaction Found");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Transaction Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<StockTransaction>>> getAllTransactions() {

		ResponseStructure<List<StockTransaction>> rs = new ResponseStructure<>();

		List<StockTransaction> transactions = stockTransactionRepo.findAll();

		rs.setData(transactions);
		rs.setMessage("All Transactions Retrieved");
		rs.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<StockTransaction>>> getTransactionsByProduct(Long productId) {

		ResponseStructure<List<StockTransaction>> rs = new ResponseStructure<>();

		List<StockTransaction> transactions = stockTransactionRepo.findByProduct_ProdId(productId);

		rs.setData(transactions);
		rs.setMessage("Transactions for Product Retrieved");
		rs.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteTransaction(Long id) {

		ResponseStructure<String> rs = new ResponseStructure<>();

		Optional<StockTransaction> transaction = stockTransactionRepo.findById(id);

		if (transaction.isPresent()) {

			stockTransactionRepo.delete(transaction.get());

			rs.setData("Deleted");
			rs.setMessage("Transaction Deleted Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Transaction Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}
}