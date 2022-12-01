package com.team3.GruppArbeteWebbService.menu.controllers;


import com.team3.GruppArbeteWebbService.menu.Menu;
import com.team3.GruppArbeteWebbService.menu.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping(path = "/menu/post")
    public ResponseEntity<Menu> saveMenu(@RequestBody Menu menu) {
        return menuService.postMenu(menu);
    }

    @PutMapping(path = "/menu/{menuId}/post-item/{itemId}")
    ResponseEntity<Menu> addItemToMenu(
            @PathVariable Long menuId,
            @PathVariable Long itemId
    ) {
        return menuService.addItemToMenu(menuId, itemId);
    }

    @GetMapping(path = "/menu/get/{id}")
    private ResponseEntity<Menu> getMenuById(@PathVariable("id") int id) {
        return menuService.getMenuById((long) id);
    }

    @DeleteMapping("/menu/delete/{id}")
    private ResponseEntity<Menu> deleteMenuById(@PathVariable("id") int id) {
        return menuService.deleteMenuById((long) id);
    }

}


