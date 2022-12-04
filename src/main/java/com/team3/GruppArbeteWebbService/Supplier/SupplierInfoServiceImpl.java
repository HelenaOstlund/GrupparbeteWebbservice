package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierInfoServiceImpl implements SupplierInfoService {

    final SupplierInfoRepository supplierInfoRepository;

    @Autowired
    public SupplierInfoServiceImpl(SupplierInfoRepository supplierInfoRepository) {
        this.supplierInfoRepository = supplierInfoRepository;
    }
    @Override
    public ResponseEntity<List<SupplierInfo>>getAllSupplierInfo() {
        try {
            List<SupplierInfo> suppliersInfo = new ArrayList<SupplierInfo>();
            supplierInfoRepository.findAll().forEach(suppliersInfo::add);
            if (suppliersInfo.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(suppliersInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<SupplierInfo> create(SupplierInfo supplierInfo){
        try {
            SupplierInfo suppliersInfo = supplierInfoRepository.save(supplierInfo);
            return new ResponseEntity<>(suppliersInfo, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity delete(int id) {
        if(supplierInfoRepository.existsById(id)){
            supplierInfoRepository.deleteById(id);

        }else {
            throw new RuntimeException("SupplierInfo-Id does not exist");
        }
        return null;
    }
}
