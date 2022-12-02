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

    public void addEmployee(Employee employee){
        this.employees.add(employee);
        employee.getTeams().add(this);
    }

    public void removeEmployee(long employeeId){
        Employee employee = this.employees.stream().filter(e -> e.getId() == employeeId).findFirst().orElse(null);
        if(employee != null){
            this.employees.remove(employee);
            employee.getTeams().remove(this);
        }
    }
    /*
    @OneToMany(mappedBy="team", fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<Employee> employees;
*/



    /*
    @Embeddable
class Allergens {

    @Column(name = "peanuts", table = "allergens")
    boolean peanuts;

    @Column(name = "celery", table = "allergens")
    boolean celery;

    @Column(name = "sesame_seeds", table = "allergens")
    boolean sesameSeeds;*/
}
