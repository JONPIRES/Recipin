package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.model.MealPlan;
import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.repository.MealPlanRepository;
import com.recipin.reciping_app.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal-plan")
public class MealPlanController {
    @Autowired
    private MealPlanRepository mealPlanRepo;

    @GetMapping
    public List<MealPlan> getUserMealPlans(@PathVariable Long userId) {
        return mealPlanRepo.findByUserId(userId);
    }

    @PostMapping
    public MealPlan createMealPlan(@RequestBody MealPlan mealPlan) {
        return mealPlanRepo.save(mealPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteMealPlan(@PathVariable Long id) {
        mealPlanRepo.deleteById(id);
    }
}
