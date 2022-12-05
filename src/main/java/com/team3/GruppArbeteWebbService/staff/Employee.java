package com.team3.GruppArbeteWebbService.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public Set<Team> getTeams() {
        return teams;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "employees")
    @JsonIgnore
    private Set<Team> teams = new HashSet<>();


    public Employee(){

    }

}
