package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierInfoService {

    final SupplierInfoRepository supplierInfoRepository;

    @Autowired
    public SupplierInfoService(SupplierInfoRepository supplierInfoRepository) {
        this.supplierInfoRepository = supplierInfoRepository;
    }

    public List<SupplierInfo> getAllSupplierInfo() {
        List<SupplierInfo> suppliersInfo = new ArrayList<SupplierInfo>();
        supplierInfoRepository.findAll().forEach(supplierInfo -> suppliersInfo.add(supplierInfo));
        return suppliersInfo;
    }

}
