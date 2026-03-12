package com.ty.SmartInventoryManagementSystem.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.SmartInventoryManagementSystem.Entity.Supplier;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;

public interface SupplierService {
	ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier);
	
	ResponseEntity<ResponseStructure<Supplier>> getSupplierById(Long id);
	
	ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers();
	
	ResponseEntity<ResponseStructure<String>> deleteSupplier(Long id);

	ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier);
}
