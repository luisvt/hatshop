import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ShippingRegionComponent } from './shipping-region.component';

const routes: Routes = [
  {path: '', component: ShippingRegionComponent},
  {path: 'add', loadChildren: () => import('./shipping-region-form/shipping-region-form.module').then(m => m.ShippingRegionFormModule)},
  {path: 'edit/:id', loadChildren: () => import('./shipping-region-form/shipping-region-form.module').then(m => m.ShippingRegionFormModule)}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShippingRegionRoutingModule {}
