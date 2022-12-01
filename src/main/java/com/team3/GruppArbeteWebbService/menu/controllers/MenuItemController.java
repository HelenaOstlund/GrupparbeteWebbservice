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
    )
    {
        return menuItemService.addIngredientToMenuItem(itemId,ingredient);
    }

    @DeleteMapping("/{itemId}/removeIngredient")
    ResponseEntity<MenuItem> removeIngredientFromItem(
            @PathVariable Long itemId,
            @RequestBody Ingredient ingredient
    ){
        return menuItemService.removeIngredientFromMenuItem(itemId,ingredient);

    }

    @PatchMapping(path = "/menu/item/update-name/{id}")
    private ResponseEntity<MenuItem> updateItemName(@PathVariable("id") int id, @RequestBody String name) {
        return menuItemService.updateItemName((long) id, name);

    }

    @GetMapping(path = "/menu/item/get/{id}")
    private ResponseEntity<MenuItem> getItemById(@PathVariable("id") int id) {
            return menuItemService.getItemById((long) id);
    }

    @DeleteMapping("/menu/item/delete/{id}")
    private ResponseEntity<MenuItem> deleteMenuById(@PathVariable("id") int id) {
        return menuItemService.deleteItemById((long) id);
    }
}
