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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    //private List<Team> teamList  = new java.util.ArrayList<>();
    private Team team;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
   // @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "name")
    String name;

    @Column(name = "ssn")
    String SSN;

    @Column(name = "role")
    Role role;

    @Column(name = "phonenumber")
    String phonenumber;


}
