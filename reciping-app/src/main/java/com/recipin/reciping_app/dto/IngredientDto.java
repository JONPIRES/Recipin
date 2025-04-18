package com.recipin.reciping_app.dto;

public class IngredientDto {

    private Long id;
    private String name;
    private String unit;
    private UserSimple createdBy;

    public IngredientDto(Long id, String name, String unit, UserSimple createdBy) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.createdBy = createdBy;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public UserSimple getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserSimple createdBy) {
        this.createdBy = createdBy;
    }
}
