package com.team3.GruppArbeteWebbService.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MenuItem")
@Getter
@Setter
@AllArgsConstructor

public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="ITEM_TYPE")
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private String price;

    public MenuItem() {

    }
}
