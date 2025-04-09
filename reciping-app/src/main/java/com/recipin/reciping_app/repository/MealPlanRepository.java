package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.MealPlan;
import com.recipin.reciping_app.model.MealPlanDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanRepository extends JpaRepository<MealPlan, Long>{

    List<MealPlan> findByUserId(Long userId);

}
