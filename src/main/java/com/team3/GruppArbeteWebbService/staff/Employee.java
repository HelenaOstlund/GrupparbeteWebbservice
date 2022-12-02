package com.team3.GruppArbeteWebbService.staff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee{


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

   // private Set<Team> teams;

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }




    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "employees")
    @JsonIgnore
    private Set<Team> teams = new HashSet<>();


    public Employee(String name, String SSN, Role role, String phonenumber) {
        this.name = name;
        this.SSN = SSN;
        this.role = role;
        this.phonenumber = phonenumber;
    }


    public Employee(){

    }

}
