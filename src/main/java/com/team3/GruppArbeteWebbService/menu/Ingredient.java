package com.team3.GruppArbeteWebbService.menu;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ingredient")
@Getter
@Setter

public class Ingredient {

    @ManyToMany(mappedBy = "ingredients")
    public Set<MenuItem> menuItems = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

}
