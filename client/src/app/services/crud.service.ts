import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Page } from '../models/page';
import { map } from 'rxjs/operators';
import { EMPTY, Observable } from 'rxjs';
import { Params } from '@angular/router';


export abstract class CrudService<T extends { id?: number }> {
  protected readonly baseUrl: string;

  protected constructor(baseUrl: string, protected http: HttpClient) {
    this.baseUrl = environment.api + baseUrl;
  }

  protected stringifyParams(params: any) {
    params = Object.assign({}, {size: 0}, params);
    for (const key of Object.keys(params)) {
      if (typeof params[key] !== 'string' && typeof params[key] !== 'number') {
        params[key] = JSON.stringify(params[key]);
      }
    }
    return params;
  }

  findById(id: string, params?: any) {
    if (!id) { return EMPTY; }
    return this.http.get<T>(this.baseUrl + '/' + id, {params});
  }

  find(params?: any) {
    params = this.stringifyParams(params);
    return this.http.get<Page<T>>(this.baseUrl, {params});
  }

  findAll(params?: Params) {
    return this.http.get<T[]>(this.baseUrl, {params})
  }

  save(item: T | any) {
    if (item.id) {
      return this.http.put<T>(this.baseUrl, item);
    } else {
      return this.http.post<T>(this.baseUrl, item);
    }
  }

  deleteById(id: string) {
    return this.http.delete(this.baseUrl + '/' + id);
  }

  delete(params: any) {
    return this.http.delete(this.baseUrl, {params});
  }
}
