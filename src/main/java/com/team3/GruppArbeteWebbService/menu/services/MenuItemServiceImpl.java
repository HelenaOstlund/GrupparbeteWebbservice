package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

   public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
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


    @Override
    public ResponseEntity<MenuItem> getItemById(Long id)
    {
        try {
            MenuItem item = menuItemRepository.findById(id).get();
            return new ResponseEntity("Item found: " + item, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<MenuItem> deleteItemById(Long id)
    {
        try {
            menuItemRepository.deleteById(id);
            return new ResponseEntity("Item deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<MenuItem> addIngredientToMenuItem(Long menuItemId, Ingredient ingredient) {

       try{
            MenuItem item = menuItemRepository.findById(menuItemId).get();
            item.getIngredients().add(ingredient);
            menuItemRepository.saveAndFlush(item);
            return new ResponseEntity("Ingredient added successfully", HttpStatus.OK);
       }catch (Exception e){
        return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
       }
    }

    @Override
    public ResponseEntity<MenuItem> removeIngredientFromMenuItem(Long menuItemId, Ingredient ingredient) {
        try{
            MenuItem item = menuItemRepository.findById(menuItemId).get();
            for (int i = 0; i < item.getIngredients().size(); i++) {
                if (item.getIngredients().get(i).getName().equalsIgnoreCase(ingredient.getName())) {
                    item.getIngredients().remove(i);
                }
            }
            menuItemRepository.saveAndFlush(item);
            return new ResponseEntity("Ingredient removed from item", HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<MenuItem> updateItemName(Long id, String name) {

       try{
            MenuItem item = menuItemRepository.findById(id).get();
            item.setName(name);
            menuItemRepository.save(item);
            return new ResponseEntity( "Item name updated" , HttpStatus.OK);
       }catch (Exception e ){
           return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
       }
    }

}
