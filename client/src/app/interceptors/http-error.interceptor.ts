import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { GlobalsService } from '../services/globals.service';

@Injectable()
export class HttpErrorInterceptor implements HttpInterceptor {

  constructor(private snackBar: MatSnackBar,
              private router: Router,
              private globalsSvc: GlobalsService) {}

  private async showError(error) {
    this.snackBar.open(error, 'OK', {duration: 5000, panelClass: 'mat-warn'});
  }

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    return next.handle(req).pipe(catchError(error => {
      if (error.status === 401) {
        this.globalsSvc.currentUser$.next(null);
        if (this.router.url === '/login') {
          this.router.navigateByUrl('/login', {replaceUrl: true});
          this.showError('Sorry, the username and password combination are incorrect. Please Try Again!')
        } else if (this.router.url !== '/') {
          this.router.navigate(['login'], {replaceUrl: true, queryParams: {redirectUrl: this.router.url}});
          this.showError('Sorry, You are not authorized to execute last request. Try to Login Again!');
        }
      } else if (error.status === 504) {
        this.showError('An unknown error has occurred, please check your internet connection.');
      } else if (error.error) {
        if (error.error.errors) {
          const errors = Object.values(error.error.errors);
          if (errors.length === 1) {
            this.showError(errors[0]);
          } else {
            this.showError(errors.join('\n'));
          }
        } else if (error.error.message) {
          this.showError(error.error.message);
        }
      } else if (error.message) {
        this.showError(error.message);
      } else {
        this.showError(error);
      }
      return throwError(error);
    }));
  }
}
