import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReimbursmnetService } from '../../reimbursment/reimbursmnet.service';
import { UserModel } from '../../reimbursment/users.model';
import { AuthService } from '../auth.service';
import { enumEmployeeType } from './epmloyee';

@Component({ selector: 'app-signup', templateUrl: './signup.component.html', styleUrls: ['./signup.component.css'] })
export class SignupComponent implements OnInit {

  employeeType: enumEmployeeType[] = [];
  dedultSelectnumber: number = 0;
  newUser: UserModel = new UserModel();
  errorMsg: string = "";
  message: string = "";
  constructor(private reimburementService: ReimbursmnetService, private authService: AuthService, private router: Router) { }
  ngOnInit(): void {
    this.employeeType = [
      {
        Id: 1,
        Name: "Employee"
      }, {
        Id: 2,
        Name: "Manegar"
      }
    ]
    // default value is Employee
    this.dedultSelectnumber = 1;
  }

  signup() {
    var n: number = this.newUser.usertype_id
    this.reimburementService.registrationService(this.newUser).subscribe((response) => { //        this.router.navigate(['update-profile']);

      console.log("my response = " + response)
      if (response != null) {
        this.newUser = response;
        this.router.navigate(['/thanks-message']);
      } else {
        this.message = 'This user is already exist';
      }
    }, (error) => {
      this.errorMsg = 'There was some enternal error!  Please try again later!';
    })
  }

}
