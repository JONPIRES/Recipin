export interface MealPlan {
  id: number;
  userId: number;
  name: string;
  days: MealPlanDay[];
}

export interface MealPlanDay {
  mealPlanId: MealPlan['id'];
  day: WeekDay; // e.g., 'Monday'
  meals: MealType;
}

export interface MealType {
  type: 'Breakfast' | 'Lunch' | 'Dinner' | 'Snack' | 'Brunch';
}

export interface WeekDay {
  day:
    | 'Monday'
    | 'Tuesday'
    | 'Wednesday'
    | 'Thursday'
    | 'Friday'
    | 'Saturday'
    | 'Sunday';
}
