import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { Shipping } from '../models/shipping';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShippingsService extends CrudService<Shipping> {

  constructor(http: HttpClient) { super('shippings', http); }
}
