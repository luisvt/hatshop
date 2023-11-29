import {Injectable} from '@angular/core';
import {CrudService} from './crud.service';
import {HttpClient} from '@angular/common/http';
import {Product} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class ProductsService extends CrudService<Product> {

  constructor(http: HttpClient) { super('products', http); }
}
