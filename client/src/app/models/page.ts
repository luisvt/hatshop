
export interface Page<T> {
  number: number;
  size: number;
  total?: number;
  content?: T[];
}
