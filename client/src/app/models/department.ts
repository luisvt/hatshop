import { Category } from './category';

export interface Department {
  id: number;
  name: string;
  description: string;
  categories: Category[]
}
