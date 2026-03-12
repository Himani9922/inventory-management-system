package com.ty.SmartInventoryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SmartInventoryManagementSystem.Entity.StockTransaction;

public interface StockTransactionRepo extends JpaRepository<StockTransaction, Long>{

		List<StockTransaction> findByProduct_ProdId(Long productId);
	
}
