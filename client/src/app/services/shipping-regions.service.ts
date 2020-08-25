import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { ShippingRegion } from '../models/shipping-region';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShippingRegionsService extends CrudService<ShippingRegion> {

  constructor(http: HttpClient) { super('shipping-regions', http); }
}
