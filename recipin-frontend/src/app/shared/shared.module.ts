import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoreModule } from '../core/core.module';
import { LayoutModule } from '../layout/layout.module';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [],
  imports: [
    CoreModule,
    CommonModule,
    LayoutModule,
    ReactiveFormsModule,
    HeaderComponent,
  ],
  exports: [CoreModule, LayoutModule, ReactiveFormsModule, HeaderComponent],
})
export class SharedModule {}
