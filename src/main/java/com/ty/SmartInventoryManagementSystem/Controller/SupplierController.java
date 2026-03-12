package com.ty.SmartInventoryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ty.SmartInventoryManagementSystem.Entity.Supplier;
import com.ty.SmartInventoryManagementSystem.Reponse.ResponseStructure;
import com.ty.SmartInventoryManagementSystem.Service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(@RequestBody Supplier supplier){
        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(@RequestBody Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteSupplier(@PathVariable Long id){
        return supplierService.deleteSupplier(id);
    }
}