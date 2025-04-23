package com.recipin.reciping_app.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.recipin.reciping_app.model.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class RecipeDto {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;

    private UserSimple createdBy;


    private List<Step> steps;

    private List<RecipeIngredient> ingredients;

    private Set<MealType> mealTypes;

    public RecipeDto() {}

    public RecipeDto(Recipe recipe, UserSimple user) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.description = recipe.getDescription();
        this.prepTime = recipe.getPrepTime();
        this.cookTime = recipe.getCookTime();
        this.servings = recipe.getServings();
        this.createdBy = user;
        this.steps = recipe.getSteps();
        this.ingredients = recipe.getIngredients();
        this.mealTypes = recipe.getMealTypes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public UserSimple getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserSimple createdBy) {
        this.createdBy = createdBy;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<MealType> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Set<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }
}
