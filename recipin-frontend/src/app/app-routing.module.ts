import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/auth/login/login.component';
import { RegisterComponent } from './pages/auth/register/register.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { MealPlanListComponent } from './pages/meal-planner/meal-plan-list/meal-plan-list.component';
import { RecipeListComponent } from './pages/recipes/recipe-list/recipe-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  { path: 'home', component: HomePageComponent },

  // Recipe Routes
  { path: 'recipes', component: RecipeListComponent },

  // Auth Routes
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  // Meal Plan Routes
  {
    path: 'my-plans',
    component: MealPlanListComponent,
  },
  { path: '**', redirectTo: 'recipes' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
