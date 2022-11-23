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
    @Autowired
    SupplierService supplierService;

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
        private int saveOrUpdateSupplier(@RequestBody Supplier supplier){
            supplierService.saveOrUpdate(supplier);
            return supplier.getId();
        }

}
