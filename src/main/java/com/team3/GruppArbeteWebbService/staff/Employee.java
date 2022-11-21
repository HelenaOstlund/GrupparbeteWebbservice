package com.team3.GruppArbeteWebbService.staff;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "SSN")
    private String SSN;

    @Column(name = "role")
    private Role role;

    @Column(name = "phonenumber")
    private String phonenumber;


}
