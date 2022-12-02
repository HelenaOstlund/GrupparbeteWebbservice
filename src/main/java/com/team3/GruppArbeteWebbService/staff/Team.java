package com.team3.GruppArbeteWebbService.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id", nullable = false)
    private long id;


    @Column(name = "name")
    private TeamType teamType;

    @Column(name = "manager_id")
    private long managerId;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "team_employee",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private Set<Employee> employees = new HashSet<>();


    public Team(TeamType teamType, long managerId) {
        this.teamType = teamType;
        this.managerId = managerId;
    }

    public Team() {

    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.getTeams().add(this);
    }

}
