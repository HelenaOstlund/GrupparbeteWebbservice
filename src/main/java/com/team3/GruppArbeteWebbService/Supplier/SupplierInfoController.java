package com.team3.GruppArbeteWebbService.Supplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


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

}