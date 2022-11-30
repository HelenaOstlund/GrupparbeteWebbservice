package com.team3.GruppArbeteWebbService.menu;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MenuItem")
@Getter
@Setter

public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    @Column(name="item_type")
    private ItemType itemType;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            })
    @JoinTable(name = "item_ingredient",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<Ingredient> ingredients;



}
