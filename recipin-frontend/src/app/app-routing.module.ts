import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'recipes', pathMatch: 'full' },
  {
    path: 'auth',
    loadChildren: () =>
      import('./Pages/auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: 'recipes',
    loadChildren: () =>
      import('./Pages/recipes/recipes.module').then((m) => m.RecipesModule),
  },
  {
    path: 'planner',
    loadChildren: () =>
      import('./Pages/meal-planner/meal-planner.module').then(
        (m) => m.MealPlannerModule
      ),
  },
  { path: '**', redirectTo: 'recipes' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
