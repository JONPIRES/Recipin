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
import java.util.ArrayList;
import java.util.HashMap;
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
    public  ResponseEntity<?> createIngredient(@RequestBody List<Ingredient> ingredients, Principal principal) {
        String email = principal.getName(); // This gets the currently logged-in user's email
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserSimple userSimple = userService.getUserSimple(user);
        List<IngredientDto> newIngredients = new ArrayList<>();
        List<IngredientDto> existingIngredients = new ArrayList<>();
        List<IngredientDto> failedIngredients = new ArrayList<>();
        HashMap<String,List<IngredientDto>> ingredientMap = new HashMap<>();

//        ingredients.forEach(ing ->
        for(Ingredient ing : ingredients) {
            Optional<Ingredient> existsIngredient = ingredientRepo.findByName(ing.getName());
            if(existsIngredient.isPresent() ){
                IngredientDto responseIng = new IngredientDto(existsIngredient.get(), userSimple);
                existingIngredients.add(responseIng);
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ingredient Already Exists");
            }else{
                ing.setCreatedBy(user); 
                try{
                    Ingredient createdIngredient = ingredientRepo.save(ing);
                    IngredientDto responseIng = new IngredientDto(createdIngredient, userSimple);
                    newIngredients.add(responseIng);
                }catch (Exception ex){
                    IngredientDto responseIng = new IngredientDto(ing, userSimple);
                    failedIngredients.add(responseIng);
                    logger.error("Error creating ingredients", ex);
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to create ingredients");
                }
            }
        };
        ingredientMap.put("new", newIngredients);
        ingredientMap.put("exists", existingIngredients);
        ingredientMap.put("failed", failedIngredients);

        return ResponseEntity.ok(ingredientMap);

    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientRepo.deleteById(id);
    }
}
