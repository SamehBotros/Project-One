import { AuthService } from './../users/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  //check first if anyone login or not from authentication service
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }
  isLoggedIn: boolean = false;

  retrieveIsLoggedIn() {
    return this.authService.isLoggedIn;
  }

  retrieveUserType() {
    return this.authService.retrieveUserType();
  }

}
