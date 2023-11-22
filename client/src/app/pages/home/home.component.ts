import { Component, OnInit } from '@angular/core';
import {Product} from "../../models/product";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  popularProducts: Product[] = [
    {id: 1, name: 'Popular Product 1', image: 'assets/images/items/1.jpg', description: 'Popular Product 1 Description', price: 179},
    {id: 1, name: 'Popular Product 2', image: 'assets/images/items/2.jpg', description: 'Popular Product 2 Description', price: 179},
    {id: 1, name: 'Popular Product 3', image: 'assets/images/items/3.jpg', description: 'Popular Product 3 Description', price: 179},
    {id: 1, name: 'Popular Product 4', image: 'assets/images/items/4.jpg', description: 'Popular Product 4 Description', price: 179},
    {id: 1, name: 'Popular Product 5', image: 'assets/images/items/5.jpg', description: 'Popular Product 5 Description', price: 179},
    {id: 1, name: 'Popular Product 6', image: 'assets/images/items/6.jpg', description: 'Popular Product 6 Description', price: 179},
    {id: 1, name: 'Popular Product 7', image: 'assets/images/items/7.jpg', description: 'Popular Product 7 Description', price: 179},
    {id: 1, name: 'Popular Product 8', image: 'assets/images/items/8.jpg', description: 'Popular Product 8 Description', price: 179},
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
