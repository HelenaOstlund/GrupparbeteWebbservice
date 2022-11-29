package com.team3.GruppArbeteWebbService.menu.repositories;

import com.team3.GruppArbeteWebbService.menu.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
