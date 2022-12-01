package com.team3.GruppArbeteWebbService.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "team")
//@SecondaryTable(name = "employee", pkJoinColumns = @PrimaryKeyJoinColumn(name = "team_id"))
public class Team {

    public Team(TeamType teamType, long managerId) {
        this.teamType = teamType;
        this.managerId = managerId;
    }

    public Team(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
   //@Column(name = "team_id", nullable = false)
    private long id;


    @Column(name = "name")
    private TeamType teamType;

    //@Column(name="listEmployees")

    @Column(name = "manager_id")
    private long managerId;

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
