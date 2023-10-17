import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HttpBasicAuthInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const authCredentials = sessionStorage.getItem('authCredentials');
    if (authCredentials != null) {
      const clonedRequest = request.clone({
        headers: request.headers.set('authorization', 'Basic ' + authCredentials)
      });
      return next.handle(clonedRequest);
    }
    return next.handle(request);
  }
}
