import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryFormRoutingModule } from './category-form-routing.module';
import { CategoryFormComponent } from './category-form.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatxModule } from 'angular-material-extended';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [CategoryFormComponent],
  imports: [
    CommonModule,
    CategoryFormRoutingModule,
    MatToolbarModule,
    MatxModule,
    FormsModule,
    MatButtonModule
  ]
})
export class CategoryFormModule { }
