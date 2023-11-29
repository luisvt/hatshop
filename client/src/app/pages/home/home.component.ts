import { Component, OnInit } from '@angular/core';
import {Product} from "../../models/product";
import {ProductsService} from "../../services/products.service";
import {ActivatedRoute} from "@angular/router";
import {switchMap} from "rxjs";
import {DepartmentsService} from "../../services/departments.service";
import {CategoriesService} from "../../services/categories.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  popularProducts: Product[] = [];

  constructor(productsService: ProductsService,
              departmentsService: DepartmentsService,
              categoriesService: CategoriesService,
              activatedRoute: ActivatedRoute) {
    activatedRoute.params.pipe(
      switchMap(params => {
        if (params.hasOwnProperty('categoryId')) {
          return categoriesService.findProducts(params['categoryId'])
        } else if (params.hasOwnProperty('departmentId')) {
          return departmentsService.findProducts(params['departmentId'])
        } else {
          return productsService.find();
        }
      })
    ).subscribe(products => {
      this.popularProducts = products.content ?? [];
    })
  }

  ngOnInit(): void {
  }

}
