package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {

    @Autowired
    MenuItemRepository menuItemRepository;

    public ResponseEntity<MenuItem> postItem(MenuItem item){

        List<MenuItem> menuItemsList = menuItemRepository.findAll();
        boolean itemInList = false;

        for (MenuItem i : menuItemsList) {
            if(i.getName().equalsIgnoreCase(item.getName())){
                itemInList = true;
                break;
            }
        }
        if (itemInList){
            return new ResponseEntity(item.getName() + " already in db", HttpStatus.BAD_REQUEST);
        }
        else {
            menuItemRepository.saveAndFlush(item);
            return new ResponseEntity(item.getName() + " posted to db", HttpStatus.OK);
        }
    }


    public MenuItem getItemById(Long id)
    {
        return menuItemRepository.findById(id).get();
    }

    public MenuItem deleteItemById(Long id)
    {
        menuItemRepository.deleteById(id);

        return null;
    }

    public ResponseEntity<MenuItem> addIngredientToMenuItem(Long menuItemId, Ingredient ingredient) {
        MenuItem item = menuItemRepository.findById(menuItemId).get();
        item.getIngredients().add(ingredient);
        menuItemRepository.saveAndFlush(item);

        return null;
    }
    public ResponseEntity<MenuItem> removeIngredientFromMenuItem(Long menuItemId, Ingredient ingredient) {
        MenuItem item = menuItemRepository.findById(menuItemId).get();
        for (int i = 0; i < item.getIngredients().size() ; i++) {
            if (item.getIngredients().get(i).getName().equalsIgnoreCase(ingredient.getName())){
                item.getIngredients().remove(i);
            }
        }
        menuItemRepository.saveAndFlush(item);

        return null;
    }

    public ResponseEntity<MenuItem> updateItemName(Long id, String name) {
       MenuItem item = menuItemRepository.findById(id).get();
       item.setName(name);
       menuItemRepository.save(item);

       return null;
    }
}
