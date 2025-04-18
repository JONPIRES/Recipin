package com.recipin.reciping_app.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Recipe implements BaseEntity {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int prepTime;
    private int cookTime;
    private int servings;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<MealType> mealTypes;

    public Recipe() {}
    public Recipe(Long id, String name, String description, int prepTime, int cookTime, int servings, User createdBy, Set<MealType> mealTypes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.createdBy = createdBy;
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

    public Set<MealType> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(Set<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }
}
