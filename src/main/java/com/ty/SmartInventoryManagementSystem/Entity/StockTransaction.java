package com.ty.SmartInventoryManagementSystem.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_transactions")
public class StockTransaction {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long stockTransId;
	private Integer quantityChanged;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransactionType transactionType;
	private LocalDateTime transactionDate;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;

	public StockTransaction() {
	}

	public Long getStockTransId() {
		return stockTransId;
	}

	public void setStockTransId(Long stockTransId) {
		this.stockTransId = stockTransId;
	}

	public Integer getQuantityChanged() {
		return quantityChanged;
	}

	public void setQuantityChanged(Integer quantityChanged) {
		this.quantityChanged = quantityChanged;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
