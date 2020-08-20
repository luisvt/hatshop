import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { Category } from '../models/category';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService extends CrudService<Category> {

  constructor(http: HttpClient) { super('categories', http); }
}
