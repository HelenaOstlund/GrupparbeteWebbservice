package com.team3.Supplier;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {



    @GetMapping("/supplier")
    public Supplier supplier() {
        return new Supplier(1, "bakery" );
    }


}
