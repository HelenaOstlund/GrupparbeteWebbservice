package com.team3.GruppArbeteWebbService.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository <Supplier, Integer >{

    @Query("SELECT s FROM Supplier s WHERE s.name = ?1")
    Optional<Supplier> existsByName(String supplierName);
}
