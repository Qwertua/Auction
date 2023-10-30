import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../authService";

@Component({
  selector: 'app-reg',
  templateUrl: './reg.component.html',
  styleUrls: ['./reg.component.css']
})
export class RegComponent {

  name: string = '';
  password: string = '';

  constructor(private router: Router, private authService: AuthService) {}

  reg() {
    this.authService.register(this.name, this.password).subscribe((user) => {
      if (user) {
        console.log('User data received:', user);
        this.router.navigate(['/login']);
      } else {
        console.log('Invalid credentials');
      }
    });
  }
}
