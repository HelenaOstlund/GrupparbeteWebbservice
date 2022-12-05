package com.team3.GruppArbeteWebbService.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "supplier_info")

public class SupplierInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "contact_person")
    private String person;

    @Column(name = "phone")
    private int phone;


    public SupplierInfo(){}


    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPerson(){
        return person;
    }
    public void setPerson(String person){
        this.person = person;
    }

    public int getPhone(){
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
