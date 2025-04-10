import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../../shared/shared.module';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { RecipeEditComponent } from './recipe-edit/recipe-edit.component';
import { RecipeCreateComponent } from './recipe-create/recipe-create.component';
import { RecipesRoutingModule } from './recipes-routing.module';

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
