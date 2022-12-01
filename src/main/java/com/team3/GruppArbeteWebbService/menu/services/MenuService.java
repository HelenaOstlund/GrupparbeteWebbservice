package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Menu;
import org.springframework.http.ResponseEntity;

public interface MenuService {
    ResponseEntity<Menu> getMenuById(Long id);
    ResponseEntity<Menu> postMenu(Menu menu);
    ResponseEntity<Menu> deleteMenuById(Long id);
    ResponseEntity<Menu> addItemToMenu(Long menuId, Long itemId);
}
