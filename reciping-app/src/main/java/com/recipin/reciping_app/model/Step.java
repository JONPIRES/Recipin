package com.recipin.reciping_app.model;

import jakarta.persistence.*;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stepOrder;
    private String instruction;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Step() {}

    public Step(Long id, int stepOrder, String instruction, Recipe recipe) {
        this.id = id;
        this.stepOrder = stepOrder;
        this.instruction = instruction;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(int stepOrder) {
        this.stepOrder = stepOrder;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
