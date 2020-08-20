import { map, take } from 'rxjs/operators';
import { User } from '../models/user';
import { ReplaySubject } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({providedIn: 'root'})
export class GlobalsService {

  currentUser$ = new ReplaySubject<User>(1);

  get currentUser() {
    return this.currentUser$.pipe(take(1)).toPromise();
  }

  loggedIn$ = this.currentUser$.pipe(map(cu => !!cu));

}
