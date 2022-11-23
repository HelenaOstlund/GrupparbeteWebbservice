package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team3.GruppArbeteWebbService.Supplier.Supplier;
import com.team3.GruppArbeteWebbService.Supplier.SupplierRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {
@Autowired
    SupplierRepository supplierRepository;

public List<Supplier> getAllSupplier() {
    List<Supplier> suppliers = new ArrayList<Supplier>();
    supplierRepository.findAll().forEach(supplier -> suppliers.add(supplier));
    return suppliers;
}

    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id).get();
    }
    public void saveOrUpdate(Supplier supplier) {
    supplierRepository.save(supplier);
    }
    public void delete(int id) {
    supplierRepository.deleteById(id);
    }

}
