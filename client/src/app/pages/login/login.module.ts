import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatxErrorsModule, MatxInputModule, MatxMenuButtonModule } from 'matx-core';


@NgModule({
  declarations: [LoginComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    MatToolbarModule,
    FormsModule,
    MatButtonModule,
    MatxMenuButtonModule,
    MatxInputModule,
    MatxErrorsModule
  ]
})
export class LoginModule { }
