package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepo;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeRepo.deleteById(id);
    }
}
