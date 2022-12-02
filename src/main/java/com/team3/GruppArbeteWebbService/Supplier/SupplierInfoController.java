package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
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
    private List<SupplierInfo> getAllSupplierInfo() {
        return supplierInfoService.getAllSupplierInfo();
    }
    @PostMapping("/supplierInfo")
    private int createSupplierInfo(@RequestBody SupplierInfo supplierInfo){
        supplierInfoService.create(supplierInfo);
        return supplierInfo.getId();
    }
    @DeleteMapping("/supplierInfo/{id}")
    private void deleteSupplierInfo(@PathVariable("id") int id) {
        supplierInfoService.delete(id);
    }

}