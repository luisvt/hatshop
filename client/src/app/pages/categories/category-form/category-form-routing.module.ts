import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CategoryFormComponent } from './category-form.component';

const routes: Routes = [{ path: '', component: CategoryFormComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryFormRoutingModule { }
