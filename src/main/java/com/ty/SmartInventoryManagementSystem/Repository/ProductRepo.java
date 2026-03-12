package com.ty.SmartInventoryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SmartInventoryManagementSystem.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
