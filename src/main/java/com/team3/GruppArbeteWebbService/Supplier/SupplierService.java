package com.team3.GruppArbeteWebbService.Supplier;


import org.springframework.http.ResponseEntity;
import java.util.List;

public interface SupplierService {



    ResponseEntity<List<Supplier>> getAllSupplier();
    ResponseEntity<Supplier> create(Supplier supplier);
    ResponseEntity<Supplier> getSupplierById(int id);
    ResponseEntity<Supplier> delete(int id);
    ResponseEntity<Supplier> update(String name, String category, int id);
}
