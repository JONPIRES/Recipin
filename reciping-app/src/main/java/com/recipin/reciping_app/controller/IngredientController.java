package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.dto.filter.FilterDefinition;
import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.repository.IngredientRepository;
import com.recipin.reciping_app.repository.RecipeRepository;
import com.recipin.reciping_app.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private FilterService filterService;

    @PostMapping("/filter")
    public List<Ingredient> getIngredients(@RequestBody FilterDefinition filterDefinition) {
        return filterService.getFilteredList(filterDefinition, Ingredient.class);
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
