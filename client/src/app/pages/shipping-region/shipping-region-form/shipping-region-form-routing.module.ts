import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ShippingRegionFormComponent } from './shipping-region-form.component';

const routes: Routes = [{ path: '', component: ShippingRegionFormComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShippingRegionFormRoutingModule { }
