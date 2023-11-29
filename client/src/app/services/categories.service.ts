import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { Category } from '../models/category';
import { HttpClient } from '@angular/common/http';
import {Product} from "../models/product";
import {Page} from "../models/page";

@Injectable({
  providedIn: 'root'
})
export class CategoriesService extends CrudService<Category> {

  constructor(http: HttpClient) { super('categories', http); }

  findProducts(categoryId: number) {
    return this.http.get<Page<Product>>(`${this.baseUrl}/${categoryId}/products`);
  }
}
