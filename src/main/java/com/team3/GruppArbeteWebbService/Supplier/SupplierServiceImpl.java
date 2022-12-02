package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public ResponseEntity<List<Supplier>> getAllSupplier(List suppliers) {
        List<Supplier> supplier = new ArrayList<Supplier>();
        supplierRepository.findAll().forEach(Supplier -> suppliers.add(supplier));
        return new ResponseEntity (suppliers, HttpStatus.OK);
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
   @Transactional
    public void update(String name, String category, int id) {
    Optional<Supplier> supplier = supplierRepository.findById(id);


        if (name != null && name.length() > 0 &&
                !Objects.equals(supplier.getName(), name)) {
            supplier.setName(name);
        }




    }


    /*@Override
    public Supplier replace(Supplier supplier, int id) {
        Supplier supplierInDB = supplierRepository.findById(id).get();

        if (Objects.nonNull(supplier.getName())) {
            supplierInDB.setName(supplier.getName());}

        return supplierRepository.save(supplierInDB);
    }
   @Override
    public Supplier edit(Supplier supplier, int id) {
        Supplier supplierInDB = supplierRepository.findById(id).get();

        if (Objects.nonNull(supplier.getName())) {
            supplierInDB.setName(supplier.getName());}

        return supplierRepository.save(supplierInDB);
    }*/
}
