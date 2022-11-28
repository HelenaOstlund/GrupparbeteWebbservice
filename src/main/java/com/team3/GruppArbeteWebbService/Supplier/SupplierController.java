package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
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
    private List<Supplier> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @GetMapping("/supplier/{id}")
    private Supplier getSupplier(@PathVariable("id") int id) {
        return supplierService.getSupplierById(id);
    }

    @DeleteMapping("/supplier/{id}")
    private void deleteSupplier(@PathVariable("id") int id) {
        supplierService.delete(id);
    }

    @PostMapping("/supplier")
        private int createSupplier(@RequestBody Supplier supplier){
            supplierService.create(supplier);
            return supplier.getId();
        }

    @PutMapping("/replaceSupplier/{id}")
        private Supplier replaceSupplier(@RequestBody Supplier supplier, @PathVariable("id") int id) {
        return supplierService.replace(supplier, id);
    }

    @PatchMapping("/updateSupplier/{id}")
            private Supplier updateSupplier(@RequestBody Supplier supplier, @PathVariable("id") int id) {
        return supplierService.edit(supplier, id);
    }

}
