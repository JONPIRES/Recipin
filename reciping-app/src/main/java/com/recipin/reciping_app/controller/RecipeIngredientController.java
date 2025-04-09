package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.model.RecipeIngredient;
import com.recipin.reciping_app.repository.RecipeIngredientRepository;
import com.recipin.reciping_app.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe-ingredients")
public class RecipeIngredientController {
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepo;

    @GetMapping
    public List<RecipeIngredient> getAllRecipeIng() {
        return recipeIngredientRepo.findAll();
    }

    @PostMapping
    public RecipeIngredient createRecipeIng(@RequestBody RecipeIngredient recipeIngredient) {
        return recipeIngredientRepo.save(recipeIngredient);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeIng(@PathVariable Long id) {
        recipeIngredientRepo.deleteById(id);
    }
}
