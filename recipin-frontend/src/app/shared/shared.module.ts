import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoreModule } from '../core/core.module';
import { LayoutModule } from '../layout/layout.module';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [],
  imports: [CoreModule, CommonModule, LayoutModule, ReactiveFormsModule],
  exports: [CoreModule, LayoutModule, ReactiveFormsModule],
})
export class SharedModule {}
