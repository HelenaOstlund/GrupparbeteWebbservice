package com.team3.GruppArbeteWebbService.menu.repositories;

import com.team3.GruppArbeteWebbService.menu.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
