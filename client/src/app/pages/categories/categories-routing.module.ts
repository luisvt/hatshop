import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CategoriesComponent } from './categories.component';

const routes: Routes = [
  {path: '', component: CategoriesComponent},
  {path: 'add', loadChildren: () => import('./category-form/category-form.module').then(m => m.CategoryFormModule)},
  {path: 'edit/:id', loadChildren: () => import('./category-form/category-form.module').then(m => m.CategoryFormModule)}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoriesRoutingModule {}
