import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RecipesRoutingModule } from './recipes-routing.module';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeEditComponent } from './recipe-edit/recipe-edit.component';
import { RecipeCreateComponent } from './recipe-create/recipe-create.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { SharedModule } from '../../shared/shared.module';
import { AuthModule } from '../auth/auth.module';

@NgModule({
  declarations: [],
  imports: [
    RecipeListComponent,
    RecipeDetailComponent,
    RecipeEditComponent,
    RecipeCreateComponent,
    CommonModule,
    SharedModule,
    RecipesRoutingModule,
  ],
})
export class RecipesModule {}
