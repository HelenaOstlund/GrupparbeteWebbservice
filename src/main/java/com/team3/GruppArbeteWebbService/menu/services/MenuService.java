package com.team3.GruppArbeteWebbService.menu.services;

import com.team3.GruppArbeteWebbService.menu.Menu;
import com.team3.GruppArbeteWebbService.menu.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {


    @Autowired
    MenuRepository menuRepository;

    public Menu postMenu(Menu menu)
    {
      return menuRepository.saveAndFlush(menu);
    };


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
