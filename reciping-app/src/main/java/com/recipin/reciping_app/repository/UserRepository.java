package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.MealPlan;
import com.recipin.reciping_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);  // You can use this to find a user by their email

}
