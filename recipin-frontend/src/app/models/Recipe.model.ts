import { User } from './';

export interface Ingredient {
  name: string;
  amount: string;
}

export interface Step {
  order: number;
  description: string;
}

export interface Recipe {
  id: number;
  name: string;
  description: string;
  prepTime: string;
  servings: number;
  user: User;
  cookTime: string;
  ingredients: Ingredient[];
  steps: Step[];
}
