package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.dto.filter.FilterDefinition;
import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Optional<Ingredient> findByName(String name);  // Example: find an ingredient by its name
}
