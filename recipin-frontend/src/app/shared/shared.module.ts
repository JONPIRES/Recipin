import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoreModule } from '../core/core.module';
import { LayoutModule } from '../layout/layout.module';

@NgModule({
  declarations: [],
  imports: [CoreModule, CommonModule, LayoutModule],
  exports: [CoreModule, LayoutModule],
})
export class SharedModule {}
