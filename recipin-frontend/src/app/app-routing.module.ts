import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/auth/login/login.component';
import { RegisterComponent } from './pages/auth/register/register.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { MealPlanListComponent } from './pages/meal-planner/meal-plan-list/meal-plan-list.component';
import { RecipeListComponent } from './pages/recipes/recipe-list/recipe-list.component';
import { AuthGuard } from './core/guards/auth.guard';
import { LoginGuard } from './core/guards/login.guard';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  { path: 'home', component: HomePageComponent },

  // Recipe Routes (public)
  { path: 'recipes', component: RecipeListComponent },

  // Auth Routes (redirect if already logged in)
  { 
    path: 'login', 
    component: LoginComponent,
    canActivate: [LoginGuard]
  },
  { 
    path: 'register', 
    component: RegisterComponent,
    canActivate: [LoginGuard]
  },

  // Protected Routes (require authentication)
  {
    path: 'my-plans',
    component: MealPlanListComponent,
    canActivate: [AuthGuard]
  },
  
  // Wildcard route (redirect to home)
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
