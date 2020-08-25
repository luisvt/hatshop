import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';
import { Department } from '../models/department';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartmentsService extends CrudService<Department> {

  constructor(http: HttpClient) { super('departments', http); }
}
