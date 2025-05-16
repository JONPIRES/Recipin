import { Component } from '@angular/core';
import { CoreModule } from 'src/app/core/core.module';
import { Recipe } from 'src/app/models';
import { SharedModule } from 'src/app/shared/shared.module';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrl: './recipe-list.component.scss',
  imports: [SharedModule],
})
export class RecipeListComponent {
  sampleData: Recipe[] = [
    {
      id: 1,
      name: 'Beef Burgundy',
      img: 'https://cdn.apartmenttherapy.info/image/upload/f_jpg,q_auto:eco,c_fill,g_auto,w_1500,ar_4:3/k%2FPhoto%2FRecipes%2F2024-09-chicken-fricasse%2Fchicken-fricasse-422',
    },
    {
      id: 2,
      name: 'Sesame Chicken',
      img: 'https://cdn.apartmenttherapy.info/image/upload/f_jpg,q_auto:eco,c_fill,g_auto,w_1500,ar_4:3/k%2FPhoto%2FRecipes%2F2024-09-chicken-fricasse%2Fchicken-fricasse-422',
    },
    {
      id: 3,
      name: 'Salmon Lemon',
      img: 'https://cdn.apartmenttherapy.info/image/upload/f_jpg,q_auto:eco,c_fill,g_auto,w_1500,ar_4:3/k%2FPhoto%2FRecipes%2F2024-09-chicken-fricasse%2Fchicken-fricasse-422',
    },
    {
      id: 4,
      name: 'Chicken Fricasee',
      img: 'https://i.ytimg.com/vi/LgA_83zf7lw/maxresdefault.jpg',
    },
  ];
}
