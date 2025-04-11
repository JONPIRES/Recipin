package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.MealPlan;
import com.recipin.reciping_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);  // You can use this to find a user by their email
    boolean existsByEmail(String email);
}
