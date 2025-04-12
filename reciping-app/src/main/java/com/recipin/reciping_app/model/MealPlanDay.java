package com.recipin.reciping_app.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MealPlanDay {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private MealPlan mealPlan;

    @Enumerated(EnumType.STRING)
    private WeekDay weekday;  // Use Enum

    private LocalDate dateFor;

    @Enumerated(EnumType.STRING)
    private MealType mealType;  // Use Enum

    @ManyToOne
    private Recipe recipe;

    public MealPlanDay() {}

    public MealPlanDay(Long id, MealPlan mealPlan, WeekDay weekday, LocalDate dateFor, MealType mealType, Recipe recipe) {
        this.id = id;
        this.mealPlan = mealPlan;
        this.weekday = weekday;
        this.dateFor = dateFor;
        this.mealType = mealType;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public WeekDay getWeekday() {
        return weekday;
    }

    public void setWeekday(WeekDay weekday) {
        this.weekday = weekday;
    }

    public LocalDate getDateFor() {
        return dateFor;
    }

    public void setDateFor(LocalDate dateFor) {
        this.dateFor = dateFor;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
