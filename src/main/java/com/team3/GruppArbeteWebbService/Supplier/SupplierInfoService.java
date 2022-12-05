package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.http.ResponseEntity;
import java.util.List;


public interface SupplierInfoService {

    ResponseEntity<List<SupplierInfo>> getAllSupplierInfo();
    ResponseEntity<SupplierInfo> create(SupplierInfo supplierInfo);
    ResponseEntity<SupplierInfo> delete(int id);


}
