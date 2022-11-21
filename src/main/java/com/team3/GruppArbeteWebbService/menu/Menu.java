package com.team3.GruppArbeteWebbService.menu;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MENU")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    private String Name;


}
