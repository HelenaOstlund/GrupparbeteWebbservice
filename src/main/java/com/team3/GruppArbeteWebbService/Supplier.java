package com.team3.GruppArbeteWebbService;

public class Supplier {

    private final long id;
    private final String name;


    public Supplier(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

}
