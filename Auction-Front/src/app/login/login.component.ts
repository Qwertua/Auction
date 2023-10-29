import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../authService";
import {user} from "../user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  users: user[] = [];
  name: string = '';
  password: string = '';

  constructor(private router: Router, private authService: AuthService) {}

  redirectToRegistration() {
    this.router.navigate(['/registration']);
  }

  login() {
    this.authService.login(this.name, this.password).subscribe((user) => {
      if (user) {
        console.log('User data received:', user);
        this.authService.setUser(user); // Обновите данные пользователя в сервисе
        this.router.navigate(['/auction']);
      } else {
        console.log('Invalid credentials');
      }
    });
  }
}
