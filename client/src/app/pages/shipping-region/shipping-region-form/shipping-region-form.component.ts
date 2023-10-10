import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { NgForm } from '@angular/forms';
import { ShippingRegionsService } from '../../../services/shipping-regions.service';
import { ShippingRegion } from '../../../models/shipping-region';

@Component({
  selector: 'app-department-form',
  templateUrl: './shipping-region-form.component.html',
  styleUrls: ['./shipping-region-form.component.scss']
})
export class ShippingRegionFormComponent {

  operation: string;

  model: ShippingRegion | any = {};

  constructor(private svc: ShippingRegionsService,
              private route: ActivatedRoute,
              private location: Location) {
    const id = route.snapshot.params['id'];
    this.operation = id ? 'edit' : 'add';
    if (id) {
      svc.findById(id).subscribe(value => this.model = value);
    }
  }

  save(form: NgForm) {
    if (form.invalid) return;

    this.svc.save(this.model).subscribe(() => this.location.back());
  }
}
