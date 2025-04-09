package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findByName(String name);  // Example: find an ingredient by its name

}
