package com.team3.GruppArbeteWebbService.menu.controllers;


import com.team3.GruppArbeteWebbService.menu.Menu;
import com.team3.GruppArbeteWebbService.menu.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping(path = "/menu/post")
    public Menu saveMenu(@RequestBody Menu menu) {
        return menuService.postMenu(menu);

    }

    @GetMapping(path = "/menu/get/{id}")
    private Menu getMenuById(@PathVariable("id") int id) {
        return menuService.getMenuById((long) id);
    }

    @DeleteMapping("/menu/delete/{id}")
    private ResponseEntity<String> deleteMenuById(@PathVariable("id") int id) {
        Menu menu = menuService.deleteMenuById((long) id);
        if (menu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Menu deleted", HttpStatus.OK);
        }

    }

}


