import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShippingRegionRoutingModule } from './shipping-region-routing.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatxModule } from 'angular-material-extended';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { NgObjectPipesModule } from 'ngx-pipes';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ShippingRegionComponent } from './shipping-region.component';


@NgModule({
  declarations: [ShippingRegionComponent],
  imports: [
    CommonModule,
    ShippingRegionRoutingModule,
    MatToolbarModule,
    MatxModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    NgObjectPipesModule,
    MatTableModule,
    MatPaginatorModule
  ]
})
export class ShippingRegionModule { }
