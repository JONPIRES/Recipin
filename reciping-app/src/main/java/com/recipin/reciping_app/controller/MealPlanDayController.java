package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.model.MealPlan;
import com.recipin.reciping_app.model.MealPlanDay;
import com.recipin.reciping_app.repository.MealPlanDayRepository;
import com.recipin.reciping_app.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal-plan")
public class MealPlanDayController {
    @Autowired
    private MealPlanDayRepository mealPlanDayRepo;

    @GetMapping
    public List<MealPlanDay> getDaysForMealPlan(@PathVariable Long planId) {
        return mealPlanDayRepo.findByMealPlanId(planId);
    }

    @PostMapping
    public MealPlanDay addMealPlanDay(@RequestBody MealPlanDay day) {
        return mealPlanDayRepo.save(day);
    }
    @DeleteMapping("/{id}")
    public void deleteMealPlan(@PathVariable Long id) {
        mealPlanDayRepo.deleteById(id);
    }
}
