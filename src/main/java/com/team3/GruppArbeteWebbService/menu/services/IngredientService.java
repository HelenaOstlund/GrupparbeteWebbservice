package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    public ResponseEntity<Ingredient> postIngredient(Ingredient ingredient){

        List<Ingredient> ingredientsList = ingredientRepository.findAll();
        boolean ingredientInList = false;

        for (Ingredient i : ingredientsList) {
            if(i.getName().equalsIgnoreCase(ingredient.getName())){
                ingredientInList = true;
                break;
            }
        }
        if (ingredientInList){
            return new ResponseEntity(ingredient.getName() + " already in db", HttpStatus.BAD_REQUEST);
        }
        else {
            ingredientRepository.saveAndFlush(ingredient);
            return new ResponseEntity(ingredient.getName() + " posted to db", HttpStatus.OK);
        }
    }

    public ResponseEntity<Ingredient> updateIngredientName(Long id, String name) {
        Ingredient ingredient = ingredientRepository.findById(id).get();
        ingredient.setName(name);
        ingredientRepository.save(ingredient);

        return null;
    }


    public Ingredient getIngredientById(Long id)
    {
        return ingredientRepository.findById(id).get();
    }

    public Ingredient deleteIngredientById(Long id)
    {
        ingredientRepository.deleteById(id);

        return null;
    }
}


