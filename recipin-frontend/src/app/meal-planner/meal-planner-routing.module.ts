import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MealPlanListComponent } from './meal-plan-list/meal-plan-list.component';

const routes: Routes = [{ path: '', component: MealPlanListComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MealPlannerRoutingModule {}
