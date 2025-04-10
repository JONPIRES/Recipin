import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from 'src/app/shared/shared.module';
import { MealPlanDetailComponent } from './meal-plan-detail/meal-plan-detail.component';
import { MealPlannerRoutingModule } from './meal-planner-routing.module';
import { MealPlanListComponent } from './meal-plan-list/meal-plan-list.component';

// TODO Import states after they're done
@NgModule({
  declarations: [],
  imports: [
    MealPlanDetailComponent,
    MealPlanListComponent,
    CommonModule,
    SharedModule,
    MealPlannerRoutingModule,
  ],
})
export class MealPlannerModule {}
