package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Menu;
import com.team3.GruppArbeteWebbService.menu.MenuItem;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuItemRepository;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {


  private final MenuRepository menuRepository;

  private final MenuItemRepository itemRepo;

    public MenuServiceImpl(MenuRepository menuRepository, MenuItemRepository itemRepo) {
        this.menuRepository = menuRepository;
        this.itemRepo = itemRepo;
    }


    @Override
    public ResponseEntity<Menu> postMenu(Menu menu)
    {
        try {
            menuRepository.saveAndFlush(menu);
            return new ResponseEntity("Menu saved" , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Exception caught: " + e, HttpStatus.BAD_REQUEST);
        }
    };

    @Override
    public ResponseEntity<Menu> addItemToMenu(Long menuId, Long itemId) {


        try{
            List<MenuItem> menuItemList = itemRepo.findAll();

            for (int i = 0; i < menuItemList.size(); i++) {
                if (menuItemList.get(i).getId() == itemId) {
                    Menu menu = menuRepository.findById(menuId).get();
                    MenuItem itemToAdd = menuItemList.get(i);
                    menu.getMenuItems().add(itemToAdd);
                    menuRepository.saveAndFlush(menu);
                }
            }
            return new ResponseEntity("Add success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error caught with code: " + e, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Menu> getMenuById(Long id)
    {
        try {
            Menu returnMenu = menuRepository.findById(id).get();
            return new ResponseEntity(returnMenu, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Error code: " +e, HttpStatus.BAD_REQUEST);
        }
    };

    @Override
    public ResponseEntity<Menu> deleteMenuById(Long id)
    {
        try{
            menuRepository.deleteById(id);
            return new ResponseEntity("Menu deleted", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("Error with code: " + e, HttpStatus.BAD_REQUEST);
        }
    };
}
