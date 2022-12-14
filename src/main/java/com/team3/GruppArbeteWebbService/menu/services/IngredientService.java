package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IngredientService {

    ResponseEntity<Ingredient> postIngredient(Ingredient ingredient);
    ResponseEntity<Ingredient> updateIngredientName(Long id, String name);
    ResponseEntity<Ingredient> getIngredientById(Long id);
    ResponseEntity<Ingredient> deleteIngredientById(Long id);
    ResponseEntity<List<Ingredient>> getAllIngredients();
}


