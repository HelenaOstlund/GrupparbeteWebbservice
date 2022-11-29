package com.team3.GruppArbeteWebbService.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MenuItem")
@Getter
@Setter

public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    @Column(name="item_type")
    private ItemType itemType;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @ManyToMany
    @JoinTable(name = "ingredients_in_item",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn (name = "ingredient_id"))
    private Set<Ingredient> ingredients = new HashSet<>();


    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}
