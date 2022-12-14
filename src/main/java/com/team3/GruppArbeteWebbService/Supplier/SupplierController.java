package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @GetMapping("/supplier")
    public ResponseEntity<List<Supplier>> getAllSupplier() {
        return supplierService.getAllSupplier();
    }
    @GetMapping("/supplier/{id}")
    public ResponseEntity<Supplier> getIdSupplier (@PathVariable("id") int id) {
        return supplierService.getSupplierById(id);
    }
    @DeleteMapping("/supplier/{id}")
    private void deleteSupplierById(@PathVariable("id") int id) {
        supplierService.delete(id);
    }
    @PostMapping("/supplier")
        public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
           return supplierService.create(supplier);
        }
    @PutMapping("/updateSupplier/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") int id, @RequestBody Supplier supplier){
        return supplierService.update(supplier.getName(), supplier.getCategory(), id);
    }
}
