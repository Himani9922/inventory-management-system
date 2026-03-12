	package com.ty.SmartInventoryManagementSystem.Entity;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	
	@Entity
	public class Product {
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		private Long prodId;
		private String prodName;
		private Double price;
		private Integer quantity;
		
		@ManyToOne
		@JoinColumn(name = "category_id")
		private Category category;
		
		@ManyToOne
		@JoinColumn(name = "supplier_id")
		private Supplier supplier;
		
		public Long getProdId() {
			return prodId;
		}
		public void setProdId(Long prodId) {
			this.prodId = prodId;
		}
		public String getProdName() {
			return prodName;
		}
		public void setProdName(String prodName) {
			this.prodName = prodName;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public Supplier getSupplier() {
			return supplier;
		}
		public void setSupplier(Supplier supplier) {
			this.supplier = supplier;
		}
	}
