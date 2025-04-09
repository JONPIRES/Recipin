package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Custom query method to find all recipes created by a specific user
    List<Recipe> findByCreatedById(Long userId);

    // You can add more custom query methods as needed.
}
