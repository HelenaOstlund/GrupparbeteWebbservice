package com.team3.GruppArbeteWebbService.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ingredient")
@Getter
@Setter

public class Ingredient {

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredients")
    private List<MenuItem> menuItems = new java.util.ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

}
