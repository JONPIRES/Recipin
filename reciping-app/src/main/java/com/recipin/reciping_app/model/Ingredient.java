package com.recipin.reciping_app.model;

import jakarta.persistence.*;

@Entity
public class Ingredient implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String unit;

    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;

    public Ingredient() {}

    public Ingredient(Long id, String name, String unit, User createdBy) {
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
