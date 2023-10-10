import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { AuthService } from './services/auth.service';
import { GlobalsService } from './services/globals.service';
import { MatxSidenavMenuService } from 'matx-core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  appPages = [
    {title: 'Home', url: '/home', icon: 'home', permissions: []},
    {title: 'Departments', url: '/departments', icon: 'group_work', permissions: ['ADMIN']},
    {title: 'Categories', url: '/categories', icon: 'category', permissions: ['ADMIN']},
    {title: 'Shipping Regions', url: '/shipping-regions', icon: 'category', permissions: ['ADMIN']},
  ];

  loggedIn$ = this.globalsSvc.loggedIn$;

  constructor(private breakpointObserver: BreakpointObserver,
              public sideNavCtrl: MatxSidenavMenuService,
              private globalsSvc: GlobalsService,
              public authSvc: AuthService) {
    this.breakpointObserver.observe([
      Breakpoints.XSmall,
      Breakpoints.Small,
    ]).subscribe(result => {
      sideNavCtrl.isMobile = result.matches;
      sideNavCtrl.opened = !sideNavCtrl.isMobile;
    })
  }

  logout() {
    this.authSvc.logout();
    this.sideNavCtrl.opened = false;
  }

}
