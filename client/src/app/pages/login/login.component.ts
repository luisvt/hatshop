import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  model = {
    username: '',
    password: ''
  };

  constructor(private authSvc: AuthService, private router: Router) { }

  async submit() {
    await this.authSvc.login(this.model);
  }
}
