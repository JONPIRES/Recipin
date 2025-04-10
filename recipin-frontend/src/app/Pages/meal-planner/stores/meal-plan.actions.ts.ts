export class LoadMealPlans {
  static readonly type = '[Meal Planner] Load Meal Plans';
}

export class AddMealPlan {
  static readonly type = '[Meal Planner] Add Meal Plan';
  constructor(public payload: any) {}
}

export class UpdateMealPlan {
  static readonly type = '[Meal Planner] Update Meal Plan';
  constructor(public id: number, public payload: any) {}
}

export class DeleteMealPlan {
  static readonly type = '[Meal Planner] Delete Meal Plan';
  constructor(public id: number) {}
}
