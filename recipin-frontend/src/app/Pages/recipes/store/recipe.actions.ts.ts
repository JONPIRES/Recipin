export class LoadRecipes {
  static readonly type = '[Recipes] Load Recipes';
}

export class AddRecipe {
  static readonly type = '[Recipes] Add Recipe';
  constructor(public payload: any) {}
}

export class UpdateRecipe {
  static readonly type = '[Recipes] Update Recipe';
  constructor(public id: number, public payload: any) {}
}

export class DeleteRecipe {
  static readonly type = '[Recipes] Delete Recipe';
  constructor(public id: number) {}
}
