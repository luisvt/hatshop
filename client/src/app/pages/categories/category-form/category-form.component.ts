import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { NgForm } from '@angular/forms';
import { CategoriesService } from '../../../services/categories.service';
import { Category } from '../../../models/category';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.scss']
})
export class CategoryFormComponent {

  operation: string;

  model: Category | any = {};

  constructor(private svc: CategoriesService,
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
