import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { NgForm } from '@angular/forms';
import { Department } from '../../../models/department';
import { DepartmentsService } from '../../../services/departments.service';
import { CategoriesService } from '../../../services/categories.service';

@Component({
  selector: 'app-department-form',
  templateUrl: './department-form.component.html',
  styleUrls: ['./department-form.component.scss']
})
export class DepartmentFormComponent {

  operation: string;

  model: Department | any = {};

  constructor(private svc: DepartmentsService,
              private route: ActivatedRoute,
              private location: Location) {
    const id = route.snapshot.params.id;
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
