import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartmentFormRoutingModule } from './department-form-routing.module';
import { DepartmentFormComponent } from './department-form.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';
import { MatxBackButtonModule, MatxErrorsModule, MatxInputModule, MatxTextareaModule } from 'matx-core';


@NgModule({
  declarations: [DepartmentFormComponent],
  imports: [
    CommonModule,
    DepartmentFormRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatButtonModule,
    NgObjectPipesModule,
    MatxBackButtonModule,
    MatxInputModule,
    MatxErrorsModule,
    MatxTextareaModule
  ]
})
export class DepartmentFormModule { }
