import { Department } from './department';

export interface Category {
  id: number;
  name: string;
  description: string;
  department: Department
}
