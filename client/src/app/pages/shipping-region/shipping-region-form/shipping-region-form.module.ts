import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShippingRegionFormRoutingModule } from './shipping-region-form-routing.module';
import { ShippingRegionFormComponent } from './shipping-region-form.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatxModule } from 'angular-material-extended';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';


@NgModule({
  declarations: [ShippingRegionFormComponent],
    imports: [
        CommonModule,
        ShippingRegionFormRoutingModule,
        MatToolbarModule,
        MatxModule,
        FormsModule,
        MatButtonModule,
        NgObjectPipesModule
    ]
})
export class ShippingRegionFormModule { }
