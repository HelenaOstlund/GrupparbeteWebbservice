package com.team3.GruppArbeteWebbService.Supplier;


import org.springframework.http.ResponseEntity;
import java.util.List;

public interface SupplierService {



    ResponseEntity<List<Supplier>> getAllSupplier(List suppliers);
    ResponseEntity<Supplier> create(Supplier supplier);
    ResponseEntity<Supplier> getSupplierById(int id);

    ResponseEntity<Supplier> delete(int id);


    public void update(String name, String category, int id);
}
