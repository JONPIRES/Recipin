package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {

    // Custom query method to find all recipes created by a specific user
    List<Step> findByRecipeId(Long recipeId);

    // You can add more custom query methods as needed.
}
