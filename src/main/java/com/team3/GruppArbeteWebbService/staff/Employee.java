package com.team3.GruppArbeteWebbService.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee{

    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    //private List<Team> teamList  = new java.util.ArrayList<>();


    private Team team;
  */

    public Employee(String name, String SSN, Role role, String phonenumber) {
        this.name = name;
        this.SSN = SSN;
        this.role = role;
        this.phonenumber = phonenumber;
    }


    public Employee(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 //   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "ssn")
    private String SSN;

    @Column(name = "role")
    private Role role;

    @Column(name = "phonenumber")
    private String phonenumber;




}
