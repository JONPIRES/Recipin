package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.MealPlanDay;
import com.recipin.reciping_app.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long>{

    List<RecipeIngredient> findByRecipeId(Long recipeId);

}
