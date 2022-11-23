package com.team3.GruppArbeteWebbService.Supplier;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "supplier_name")
    private String name;

    public Supplier (){

    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
