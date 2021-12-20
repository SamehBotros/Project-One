import { AuthService } from './../auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserServices } from '../users.service';
import { ReimbursmnetService } from '../../reimbursment/reimbursmnet.service';
import { UserModel } from '../../reimbursment/users.model';

@Component({ selector: 'app-login', templateUrl: './login.component.html', styleUrls: ['./login.component.css'] })
export class LoginComponent implements OnInit {

  newUser: UserModel = new UserModel();
  EMPLOYEE: any;
  MANAGER: any;
  errorMsg: string = "";

  constructor(public authService: AuthService, private reimbursmnetService: ReimbursmnetService, private userServices: UserServices, private router: Router) { }

  ngOnInit(): void { }

  validataLogin() {
    this.reimbursmnetService.validataLoginService(this.newUser).subscribe((response) => {
      if (response.id != 0) {

        this.authService.storeUser(response);
        // if the user lodin set the isLoggedIn=true;
        this.authService.isLoggedIn = true;
        if (response.usertype_id == "EMPLOYEE") {
          this.router.navigate(['/request']);
        } else if (response.usertype_id == "MANAGER") {
          this.router.navigate(['/all-Pending-Request']);
        }
      } else {

        this.errorMsg = 'Sorry wrong username or password';
      }

    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }
}
