import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DepartmentFormComponent } from './department-form.component';

const routes: Routes = [{ path: '', component: DepartmentFormComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DepartmentFormRoutingModule { }
