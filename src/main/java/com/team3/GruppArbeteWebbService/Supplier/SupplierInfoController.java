package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SupplierInfoController {

    private final SupplierInfoService supplierInfoService;

    @Autowired
    public SupplierInfoController(SupplierInfoService supplierInfoService) {
        this.supplierInfoService = supplierInfoService;
    }
    @GetMapping("/supplierInfo")
    public ResponseEntity<List<SupplierInfo>> getAllSupplierInfo() {
        return supplierInfoService.getAllSupplierInfo();
    }
    @PostMapping("/supplierInfo")
    public ResponseEntity <SupplierInfo> createSupplierInfo(@RequestBody SupplierInfo supplierInfo){
        return supplierInfoService.create(supplierInfo);
    }
    @DeleteMapping("/supplierInfo/{id}")
    public ResponseEntity <SupplierInfo> deleteSupplierInfoById(@PathVariable("id") int id) {
        return supplierInfoService.delete(id);
    }

}