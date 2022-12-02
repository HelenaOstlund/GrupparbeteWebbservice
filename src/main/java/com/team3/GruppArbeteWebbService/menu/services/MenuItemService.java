package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import org.springframework.http.ResponseEntity;

public interface MenuItemService {
    ResponseEntity<MenuItem> postItem(MenuItem item);
    ResponseEntity<MenuItem> getItemById(Long id);
    ResponseEntity<MenuItem> deleteItemById(Long id);
    ResponseEntity<MenuItem> addIngredientToMenuItem(Long itemId, Ingredient ingredient);
    ResponseEntity<MenuItem> removeIngredientFromMenuItem(Long itemId, Ingredient ingredient);
    ResponseEntity<MenuItem> updateItemName(Long id, String name);
    ResponseEntity<MenuItem> addIngredientById(Long itemId, Long ingredientId);
}
