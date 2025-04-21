package com.recipin.reciping_app.dto;

import com.recipin.reciping_app.model.Ingredient;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.repository.UserRepository;
import com.recipin.reciping_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientDto {

    private Long id;
    private String name;
    private String unit;
    private UserSimple createdBy;

    public IngredientDto(Ingredient ingredient, UserSimple userSimple) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.unit = ingredient.getUnit();
        this.createdBy = userSimple;
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
