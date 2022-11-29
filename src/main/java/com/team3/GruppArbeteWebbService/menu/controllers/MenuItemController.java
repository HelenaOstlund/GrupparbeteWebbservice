package com.team3.GruppArbeteWebbService.menu.controllers;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.services.IngredientService;
import com.team3.GruppArbeteWebbService.menu.services.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuItemController {

    @Autowired
    MenuItemService menuItemService;

    @Autowired
    IngredientService ingredientService;

    @PostMapping(path = "/menu/item/post")
    private ResponseEntity<MenuItem> saveMenuItem(@RequestBody MenuItem item) {

        return menuItemService.postItem(item);
    }

    @PutMapping("/{itemId}/addIngredient")
    ResponseEntity<MenuItem> addIngredientToItem(
            @PathVariable Long itemId,
            @RequestBody Ingredient ingredient
    ){
        MenuItem menuItem = menuItemService.getItemById(itemId);
        menuItemService.addIngredientToMenuItem(itemId,ingredient);
        return menuItemService.postItem(menuItem);
    }

    @PatchMapping(path = "/menu/item/update-name/{id}")
    private ResponseEntity<MenuItem> updateItemName(@PathVariable("id") int id, @RequestBody String name) {
        try {
            menuItemService.updateItemName((long) id, name);
            return new ResponseEntity("Name updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Menu item not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/menu/item/get/{id}")
    private ResponseEntity<MenuItem> getMenuById(@PathVariable("id") int id) {
        try {
            MenuItem menuItem = menuItemService.getItemById((long) id);
            return new ResponseEntity(menuItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Menu item not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/menu/item/delete/{id}")
    private ResponseEntity<MenuItem> deleteMenuById(@PathVariable("id") int id) {
        try {
            MenuItem menuItem = menuItemService.deleteItemById((long) id);
            return new ResponseEntity("Menu item deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Menu item not found: " + e, HttpStatus.NOT_FOUND);
        }
    }
}
