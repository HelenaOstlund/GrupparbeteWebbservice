package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import com.team3.GruppArbeteWebbService.menu.Menu;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuItemRepository;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.awt.SystemColor.menu;

@Service
public class MenuService {


    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuItemRepository itemRepo;

    public Menu postMenu(Menu menu)
    {
      return menuRepository.saveAndFlush(menu);
    };

    public ResponseEntity<Menu> addItemToMenu(Long menuId, Long itemId) {


        List<MenuItem> menuItemList = itemRepo.findAll();

        for (int i = 0; i < menuItemList.size() ; i++) {
            if (menuItemList.get(i).getId() == itemId){
               Menu menu = menuRepository.findById(menuId).get();
               MenuItem itemToAdd = menuItemList.get(i);
               menu.getMenuItems().add(itemToAdd);
                menuRepository.saveAndFlush(menu);
                System.out.println("Added succecfully");
            }
        }
        System.out.println("Add not successful");
        return null;
    }

    public Menu getMenuById(Long id)
    {
        return menuRepository.findById(id).get();
    };
    public Menu deleteMenuById(Long id)
    {
        menuRepository.deleteById(id);
        return null;
    };
}
