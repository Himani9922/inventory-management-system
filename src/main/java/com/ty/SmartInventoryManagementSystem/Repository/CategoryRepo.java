package com.ty.SmartInventoryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SmartInventoryManagementSystem.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
