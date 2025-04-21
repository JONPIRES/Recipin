package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.dto.IngredientDto;
import com.recipin.reciping_app.dto.JwtResponse;
import com.recipin.reciping_app.dto.UserSimple;
import com.recipin.reciping_app.dto.filter.FilterDefinition;
import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.repository.IngredientRepository;
import com.recipin.reciping_app.repository.RecipeRepository;
import com.recipin.reciping_app.repository.UserRepository;
import com.recipin.reciping_app.service.FilterService;
import com.recipin.reciping_app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);
    @Autowired
    private IngredientRepository ingredientRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;


    @Autowired
    private FilterService filterService;

    @PostMapping("/filter")
    public List<Ingredient> getIngredients(@RequestBody FilterDefinition filterDefinition) {
        return filterService.getFilteredList(filterDefinition, Ingredient.class);
    }

    @PostMapping
    public  ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient, Principal principal) {
        String email = principal.getName(); // This gets the currently logged-in user's email
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Ingredient> existsIngredient = ingredientRepo.findByName(ingredient.getName());
        if(existsIngredient.isPresent() ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ingredient Already Exists");
        }
        ingredient.setCreatedBy(user);
        Ingredient createdIngredient = ingredientRepo.save(ingredient);
        try{
            UserSimple userSimple = userService.getUserSimple(user);
            IngredientDto responseIng = new IngredientDto(createdIngredient, userSimple);
            return ResponseEntity.ok(responseIng);
        }catch (Exception ex){
            logger.error("Error creating ingredient", ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to create ingredient");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientRepo.deleteById(id);
    }
}
