import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) }, { path: 'recipes', loadChildren: () => import('./recipes/recipes.module').then(m => m.RecipesModule) }, { path: 'planner', loadChildren: () => import('./meal-planner/meal-planner.module').then(m => m.MealPlannerModule) }, { path: 'planner', loadChildren: () => import('./meal-planner/meal-planner.module').then(m => m.MealPlannerModule) }, { path: 'planner', loadChildren: () => import('./meal-planner/meal-planner.module').then(m => m.MealPlannerModule) }, { path: 'planner', loadChildren: () => import('./meal-planner/meal-planner.module').then(m => m.MealPlannerModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
