package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ResponseEntity<Supplier> getSupplierById(int id){
        try {
            Supplier supplier =  supplierRepository.findById(id).get();
            return new ResponseEntity<>(supplier, HttpStatus.OK);

        }catch (Exception e){
          return new ResponseEntity("Error code" + e , HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<List<Supplier>> getAllSupplier() {
        try {
            List<Supplier> suppliers = new ArrayList<>();
            supplierRepository.findAll().forEach(suppliers::add);
            if (suppliers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Supplier> create(Supplier supplier) {
        Optional<Supplier> supplierOptional = supplierRepository.existsByName(supplier.getName());
        if (supplierOptional.isPresent()){
            return  new ResponseEntity("Supplier already exist", HttpStatus.BAD_REQUEST);
        }
        supplierRepository.save(supplier);
        return new ResponseEntity("insert ok", HttpStatus.OK);
    }
    @Override
    public ResponseEntity delete(int id) {
        if(supplierRepository.existsById(id)){
            supplierRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Supplier with id " + id + " does not exist");
        }
        return null;
    }

    @Override
    public ResponseEntity<Supplier> update(String name, String category, int id) {
        Supplier supplier = supplierRepository.findById(id).get();
        if (Objects.nonNull(name) && !"".equalsIgnoreCase(name)){
            supplier.setName(name);
        }
        if (Objects.nonNull(category) && !"".equalsIgnoreCase(category)){
            supplier.setCategory(category);
        }
        supplierRepository.save(supplier);
        return new ResponseEntity("update ok", HttpStatus.OK);
    }

}

