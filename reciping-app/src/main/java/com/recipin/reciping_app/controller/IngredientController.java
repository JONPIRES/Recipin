package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.repository.IngredientRepository;
import com.recipin.reciping_app.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepo;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientRepo.deleteById(id);
    }
}
