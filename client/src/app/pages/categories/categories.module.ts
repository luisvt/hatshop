import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriesRoutingModule } from './categories-routing.module';
import { CategoriesComponent } from './categories.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatxInputModule, MatxMenuButtonModule } from 'matx-core';


@NgModule({
  declarations: [CategoriesComponent],
  imports: [
    CommonModule,
    CategoriesRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    NgObjectPipesModule,
    MatTableModule,
    MatPaginatorModule,
    MatxMenuButtonModule,
    MatxInputModule
  ]
})
export class CategoriesModule { }
