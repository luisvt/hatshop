import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { Department } from '../models/department';
import { HttpClient } from '@angular/common/http';
import {Product} from "../models/product";
import {Page} from "../models/page";

@Injectable({
  providedIn: 'root'
})
export class DepartmentsService extends CrudService<Department> {

  constructor(http: HttpClient) { super('departments', http); }

  findProducts(departmentId: number) {
    return this.http.get<Page<Product>>(`${this.baseUrl}/${departmentId}/products`);
  }
}
