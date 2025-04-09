package com.recipin.reciping_app.repository;

import com.recipin.reciping_app.model.MealPlanDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealPlanDayRepository extends JpaRepository<MealPlanDay, Long>{

    List<MealPlanDay> findByMealPlanId(Long mealPlanId);

}
