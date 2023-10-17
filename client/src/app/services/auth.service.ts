import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxPermissionsService } from 'ngx-permissions';
import { GlobalsService } from './globals.service';
import { User } from '../models/user';
import { tap } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private redirectUrl: string = '';

  constructor(private router: Router,
              private http: HttpClient,
              private permissionsSvc: NgxPermissionsService,
              private globalsSvc: GlobalsService,
              private cookieService: CookieService,
              route: ActivatedRoute) {
    route.queryParams.subscribe(queryParams => this.redirectUrl = queryParams['redirectUrl']);

    let currentUser = sessionStorage.getItem('current_user');
    if (currentUser) {
      globalsSvc.currentUser$.next(JSON.parse(currentUser));
    } else {
      globalsSvc.currentUser$.next(null);
    }

    globalsSvc.currentUser$.subscribe(currentUser => {
      if (currentUser) {
        currentUser.roles.forEach(a => this.permissionsSvc.addPermission(a.role.replace('ROLE_', '')));
        // console.log('this.permissionsSvc.getPermissions(): ', this.permissionsSvc.getPermissions());
      } else {
        sessionStorage.removeItem('current_user');
        permissionsSvc.flushPermissions();
      }
    });
  }

  async login(credentials: { username: string, password: string }) {
    let authCredentials = btoa(credentials.username + ':' + credentials.password);
    return this.http.get<User>(
      environment.api + 'session-user', {
        params: {$expand: 'roles'},
        headers: {authorization: 'Basic ' + authCredentials}
      }
    ).pipe(tap(currentUser => {
      sessionStorage.setItem('authCredentials', authCredentials)
      sessionStorage.setItem('current_user', JSON.stringify(currentUser));
      this.globalsSvc.currentUser$.next(currentUser);
      this.router.navigateByUrl(this.redirectUrl || '/home');
    })).toPromise();
  }

  async logout() {
    await this.http.post(environment.api + 'logout', null).toPromise();
    sessionStorage.clear();
    this.globalsSvc.currentUser$.next(null);
    this.router.navigateByUrl('/login', {replaceUrl: true});
  }

  signUp(credentials: { username: string, password: string }) {
    return this.http.post(environment.api + 'sign-up', credentials);
  }

}
