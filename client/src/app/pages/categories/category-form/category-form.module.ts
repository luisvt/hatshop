import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryFormRoutingModule } from './category-form-routing.module';
import { CategoryFormComponent } from './category-form.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import {
  MatxBackButtonModule,
  MatxErrorsModule,
  MatxInputModule,
  MatxSelectModule,
  MatxTextareaModule
} from 'matx-core';


@NgModule({
  declarations: [CategoryFormComponent],
  imports: [
    CommonModule,
    CategoryFormRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatButtonModule,
    MatxBackButtonModule,
    MatxInputModule,
    MatxErrorsModule,
    MatxTextareaModule,
    MatxSelectModule
  ]
})
export class CategoryFormModule { }
