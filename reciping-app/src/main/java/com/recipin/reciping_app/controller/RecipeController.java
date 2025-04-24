package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.dto.RecipeDto;
import com.recipin.reciping_app.dto.UserSimple;
import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.repository.RecipeRepository;
import com.recipin.reciping_app.repository.UserRepository;
import com.recipin.reciping_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeRepository recipeRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe, Principal principal) {

        String email = principal.getName(); // This gets the currently logged-in user's email
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Recipe> dbRecipe = recipeRepo.findByNameAndCreatedBy(recipe.getName(), user);
        if(dbRecipe.isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recipe Already Exists");

        recipe.setCreatedBy(user);

        if (recipe.getSteps() != null) {
            recipe.getSteps().forEach(step -> step.setRecipe(recipe));
        }
        if (recipe.getIngredients() != null) {
            recipe.getIngredients().forEach(ri -> ri.setRecipe(recipe));
        }
        UserSimple userSimple = userService.getUserSimple(user);
        Recipe saved = recipeRepo.save(recipe);
        RecipeDto recipeDto = new RecipeDto(saved, userSimple);
        return ResponseEntity.ok(recipeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeRepo.deleteById(id);
    }
}
