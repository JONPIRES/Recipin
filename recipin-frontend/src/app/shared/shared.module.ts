import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthModule } from '../Pages/auth/auth.module';
import { CoreModule } from '../core/core.module';
import { LayoutModule } from '../layout/layout.module';

@NgModule({
  declarations: [],
  imports: [AuthModule, CoreModule, CommonModule, LayoutModule],
  exports: [AuthModule, CoreModule, LayoutModule],
})
export class SharedModule {}
