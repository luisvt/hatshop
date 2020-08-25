import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepartmentFormRoutingModule } from './department-form-routing.module';
import { DepartmentFormComponent } from './department-form.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatxModule } from 'angular-material-extended';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';


@NgModule({
  declarations: [DepartmentFormComponent],
    imports: [
        CommonModule,
        DepartmentFormRoutingModule,
        MatToolbarModule,
        MatxModule,
        FormsModule,
        MatButtonModule,
        NgObjectPipesModule
    ]
})
export class DepartmentFormModule { }
