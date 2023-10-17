import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from "@angular/material/snack-bar";
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgxPermissionsModule } from 'ngx-permissions';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { HttpErrorInterceptor } from './interceptors/http-error.interceptor';
import { GlobalsService } from './services/globals.service';
import { XRequestWithInterceptor } from './interceptors/x-request-with.interceptor';
import {MatxNavTreeModule, MatxPromptModule} from 'matx-core';
import {HttpBasicAuthInterceptor} from "./interceptors/http-basic-auth.interceptor";
import {MatTreeModule} from "@angular/material/tree";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        HttpClientModule,
        NgxPermissionsModule.forRoot(),
        MatSidenavModule,
        MatToolbarModule,
        MatListModule,
        MatIconModule,
        MatSnackBarModule,
        MatxPromptModule,
        MatTreeModule,
        MatButtonModule,
        MatxNavTreeModule
    ],
  providers: [
    CookieService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true,
      deps: [MatSnackBar, Router, GlobalsService]
    },
    {provide: HTTP_INTERCEPTORS, useClass: HttpBasicAuthInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: XRequestWithInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
