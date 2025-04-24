package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.Recipe;
import com.recipin.reciping_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Custom query method to find all recipes created by a specific user
    List<Recipe> findByCreatedById(Long userId);
    Optional<Recipe> findByNameAndCreatedBy(String name, User createdBy);    // You can add more custom query methods as needed.
}
