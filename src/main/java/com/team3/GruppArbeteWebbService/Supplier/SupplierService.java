package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierService {

    final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSupplier() {
        List<Supplier> suppliers = new ArrayList<Supplier>();
        supplierRepository.findAll().forEach(supplier -> suppliers.add(supplier));
        return suppliers;
    }

    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id).get();
    }

    public void create(Supplier supplier) {
        Optional<Supplier> supplierOptional = supplierRepository.existsByName(supplier.getName());
        if (supplierOptional.isPresent()){
            throw new IllegalStateException("Supplier already exists");
        }
        supplierRepository.save(supplier);
    }

    public void delete(int id) {
        if(supplierRepository.existsById(id)){
            supplierRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Supplier with id " + id + " does not exist");
        }
    }

    public Supplier replace(Supplier supplier, int id) {
        Supplier supplierInDB = supplierRepository.findById(id).get();

        if (Objects.nonNull(supplier.getName())) {
            supplierInDB.setName(supplier.getName());}

            return supplierRepository.save(supplierInDB);
        }
    public Supplier edit(Supplier supplier, int id) {
        Supplier supplierInDB = supplierRepository.findById(id).get();

        if (Objects.nonNull(supplier.getName())) {
            supplierInDB.setName(supplier.getName());}

        return supplierRepository.save(supplierInDB);
    }

    }
