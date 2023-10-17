import {Component} from '@angular/core';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {AuthService} from './services/auth.service';
import {GlobalsService} from './services/globals.service';
import {MatxNavTreeItem, MatxSidenavMenuService} from 'matx-core';
import {NgxPermissionsService} from "ngx-permissions";

interface AppPageNode {
  title: string,
  url?: string,
  icon: string,
  permissions: string[],
  children?: AppPageNode[]
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  appPages: MatxNavTreeItem[] = [];

  loggedIn$ = this.globalsSvc.loggedIn$;

  constructor(private breakpointObserver: BreakpointObserver,
              public sideNavCtrl: MatxSidenavMenuService,
              private globalsSvc: GlobalsService,
              public authSvc: AuthService,
              permissionsService: NgxPermissionsService) {
    permissionsService.permissions$.subscribe(permissions => {
      const hasAdminPermissions = Object.keys(permissions).includes('ADMIN');

      this.appPages = [
        {displayName: 'Home', route: '/home', iconName: 'home'},
        ...(hasAdminPermissions ? [{
          displayName: 'Settings', iconName: 'settings', children: [
            {displayName: 'Departments', route: '/settings/departments', iconName: 'group_work'},
            {displayName: 'Categories', route: '/settings/categories', iconName: 'category'},
            {
              displayName: 'Shipping Regions',
              route: '/settings/shipping-regions',
              iconName: 'category'
            },
          ]
        }] : [])
      ]
    });
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
