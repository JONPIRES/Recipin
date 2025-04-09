import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MealPlannerRoutingModule } from './meal-planner-routing.module';
import { MealPlannerComponent } from './meal-planner.component';


@NgModule({
  declarations: [
    MealPlannerComponent
  ],
  imports: [
    CommonModule,
    MealPlannerRoutingModule
  ]
})
export class MealPlannerModule { }
