package com.team3.GruppArbeteWebbService.menu.services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
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

    @Override
    public ResponseEntity<Ingredient> updateIngredientName(Long id, String name) {
        Ingredient ingredient = ingredientRepository.findById(id).get();
        ingredient.setName(name);
        ingredientRepository.save(ingredient);

        return null;
    }

    @Override
    public ResponseEntity<Ingredient> getIngredientById(Long id)
    {
        try{
            Ingredient ingredient = ingredientRepository.findById(id).get();
            return new ResponseEntity("Ingredientname: " + ingredient.getName(), HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity("No ingredient with id: " + id, HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public ResponseEntity<Ingredient> deleteIngredientById(Long id)
    {
        try{
            ingredientRepository.deleteById(id);
            return new ResponseEntity("Ingredient deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        try {
            return new ResponseEntity(ingredientRepository.findAll() , HttpStatus.OK);
        }
        catch (Exception e ){
            return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
        }
    }
}
