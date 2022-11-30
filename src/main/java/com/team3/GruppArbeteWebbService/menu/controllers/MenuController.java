package com.team3.GruppArbeteWebbService.menu.controllers;


import com.team3.GruppArbeteWebbService.menu.Menu;
import com.team3.GruppArbeteWebbService.menu.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping(path = "/menu/post")
    public Menu saveMenu(@RequestBody Menu menu) {
        return menuService.postMenu(menu);
    }

    @PutMapping(path = "/menu/{menuId}/post-item/{itemId}")
    ResponseEntity<Menu> addItemToMenu(
            @PathVariable Long menuId,
            @PathVariable Long itemId
    ){
        try{
            menuService.addItemToMenu(menuId, itemId);
            return new ResponseEntity("Item added to menu", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Menu not found. Exception: " + e, HttpStatus.BAD_REQUEST);

        }
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


