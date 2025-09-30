package com.recipin.reciping_app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
public class Recipe implements BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "Recipe name is required")
    @Size(min = 2, max = 100, message = "Recipe name must be between 2 and 100 characters")
    private String name;
    
    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;
    
    @NotNull(message = "Preparation time is required")
    @Positive(message = "Preparation time must be positive")
    private int prepTime;
    
    @NotNull(message = "Cooking time is required")
    @Positive(message = "Cooking time must be positive")
    private int cookTime;
    
    @NotNull(message = "Servings is required")
    @Positive(message = "Servings must be positive")
    private int servings;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Step> steps;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<RecipeIngredient> ingredients;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<MealType> mealTypes;

    public Recipe() {}

    public Recipe(Long id, String name, String description, int prepTime, int cookTime, int servings, User createdBy, List<Step> steps, List<RecipeIngredient> ingredients, Set<MealType> mealTypes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.createdBy = createdBy;
        this.steps = steps;
        this.ingredients = ingredients;
        this.mealTypes = mealTypes;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
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
