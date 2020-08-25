import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DepartmentsComponent } from './departments.component';

const routes: Routes = [
  {path: '', component: DepartmentsComponent},
  {path: 'add', loadChildren: () => import('./department-form/department-form.module').then(m => m.DepartmentFormModule)},
  {path: 'edit/:id', loadChildren: () => import('./department-form/department-form.module').then(m => m.DepartmentFormModule)}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DepartmentsRoutingModule {}
