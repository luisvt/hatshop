import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ngxPermissionsGuard } from 'ngx-permissions';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule)},
  {path: 'departments/:departmentId/products', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule)},
  {path: 'departments/:departmentId/categories/:categoryId/products', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule)},
  {path: 'login', loadChildren: () => import('./pages/login/login.module').then(m => m.LoginModule)},
  {
    path: 'settings/departments',
    loadChildren: () => import('./pages/departments/departments.module').then(m => m.DepartmentsModule),
    canActivate: [ngxPermissionsGuard],
    data: {permissions: {only: ['ADMIN'], redirectTo: 'home'}}
  },
  {
    path: 'settings/categories',
    loadChildren: () => import('./pages/categories/categories.module').then(m => m.CategoriesModule),
    canActivate: [ngxPermissionsGuard],
    data: {permissions: {only: ['ADMIN'], redirectTo: 'home'}}
  },
  {
    path: 'settings/shipping-regions',
    loadChildren: () => import('./pages/shipping-region/shipping-region.module').then(m => m.ShippingRegionModule),
    canActivate: [ngxPermissionsGuard],
    data: {permissions: {only: ['ADMIN'], redirectTo: 'home'}}
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
