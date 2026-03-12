package com.ty.SmartInventoryManagementSystem.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SmartInventoryManagementSystem.Entity.Supplier;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Repository.SupplierRepo;
import com.ty.SmartInventoryManagementSystem.Service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepo supplierRepo;

	@Override
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier) {

		Supplier savedSupplier = supplierRepo.save(supplier);

		ResponseStructure<Supplier> rs = new ResponseStructure<>();
		rs.setData(savedSupplier);
		rs.setMessage("Supplier Data Saved Successfully");
		rs.setStatusCode(HttpStatus.CREATED.value());

		return new ResponseEntity<>(rs, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(Long id) {

		Optional<Supplier> supplier = supplierRepo.findById(id);
		ResponseStructure<Supplier> rs = new ResponseStructure<>();

		if (supplier.isPresent()) {

			rs.setData(supplier.get());
			rs.setMessage("Supplier Found");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Supplier Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers() {

		List<Supplier> supplierList = supplierRepo.findAll();

		ResponseStructure<List<Supplier>> rs = new ResponseStructure<>();
		rs.setData(supplierList);
		rs.setMessage("All Suppliers Retrieved");
		rs.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(rs, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier) {

		Optional<Supplier> existingSupplier = supplierRepo.findById(supplier.getSupplierId());

		ResponseStructure<Supplier> rs = new ResponseStructure<>();

		if (existingSupplier.isPresent()) {

			Supplier updatedSupplier = supplierRepo.save(supplier);

			rs.setData(updatedSupplier);
			rs.setMessage("Supplier Updated Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Supplier Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteSupplier(Long id) {

		Optional<Supplier> supplier = supplierRepo.findById(id);
		ResponseStructure<String> rs = new ResponseStructure<>();

		if (supplier.isPresent()) {

			supplierRepo.delete(supplier.get());

			rs.setData("Deleted");
			rs.setMessage("Supplier Deleted Successfully");
			rs.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<>(rs, HttpStatus.OK);
		}

		rs.setData(null);
		rs.setMessage("Supplier Not Found");
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	}
}