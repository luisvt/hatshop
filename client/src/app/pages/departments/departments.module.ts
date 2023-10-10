import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartmentsRoutingModule } from './departments-routing.module';
import { DepartmentsComponent } from './departments.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatxInputModule, MatxMenuButtonModule, MatxPromptModule } from 'matx-core';
import { MatDialogModule } from '@angular/material/dialog';


@NgModule({
  declarations: [DepartmentsComponent],
  imports: [
    CommonModule,
    DepartmentsRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    NgObjectPipesModule,
    MatTableModule,
    MatPaginatorModule,
    MatxMenuButtonModule,
    MatxInputModule,
    MatDialogModule
  ]
})
export class DepartmentsModule { }
