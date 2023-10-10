import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShippingRegionFormRoutingModule } from './shipping-region-form-routing.module';
import { ShippingRegionFormComponent } from './shipping-region-form.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';
import { MatxBackButtonModule, MatxErrorsModule, MatxInputModule } from 'matx-core';


@NgModule({
  declarations: [ShippingRegionFormComponent],
  imports: [
    CommonModule,
    ShippingRegionFormRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatButtonModule,
    NgObjectPipesModule,
    MatxBackButtonModule,
    MatxInputModule,
    MatxErrorsModule
  ]
})
export class ShippingRegionFormModule { }
