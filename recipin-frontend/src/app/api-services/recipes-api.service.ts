import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Recipe } from '../models';

@Injectable({
  providedIn: 'root',
})
export class RecipesApiService {
  constructor(private http: HttpClient) {}

  private api = '/api/recipes';

  getAllRecipes() {
    return this.http.get<Recipe[]>(this.api);
  }

  createRecipe(recipe: Recipe) {
    return this.http.post<Recipe>(this.api, recipe);
  }

  deleteRecipe(id: number) {
    return this.http.delete(`${this.api}/${id}`);
  }
}
