package com.team3.GruppArbeteWebbService.menu.controllers;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @PostMapping(path = "/menu/ingredient/post")
    private ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.postIngredient(ingredient);
    }

    @PatchMapping(path = "/menu/ingredient/update-name/{id}")
    private ResponseEntity<Ingredient> updateIngredientName(@PathVariable("id") int id, @RequestBody String name) {
        try {
            ingredientService.updateIngredientName((long) id, name);
            return new ResponseEntity("Name updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Menu item not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/menu/ingredient/get/{id}")
    private ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") int id) {
        return ingredientService.getIngredientById((long) id);
    }

    @GetMapping("/menu/ingredient/all")
    private ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @DeleteMapping("/menu/ingredient/delete/{id}")
    private ResponseEntity<Ingredient> deleteIngredientById(@PathVariable("id") int id) {
        return ingredientService.deleteIngredientById((long) id);
    }

}
