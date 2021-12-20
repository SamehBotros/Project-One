import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authServices: AuthService, private router: Router) { }

  ngOnInit(): void {
    // remove user from session
    this.authServices.removeUser();
    // set isLoggedIn=false when the user logout
    this.authServices.isLoggedIn = false;
    this.router.navigate(['']);
  }

}
