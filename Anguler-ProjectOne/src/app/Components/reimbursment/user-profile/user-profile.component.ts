import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../users/auth.service';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { UserModel } from '../users.model';


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  errorMsg: string = "";
  newUser: UserModel = new UserModel();

  constructor(private reimburementService: ReimbursmnetService,
    private authService: AuthService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    var data: UserModel = this.authService.getUser();
    var dataNumber: number = data.id;
    this.viewEmployeeProfileService(dataNumber);
  }

  viewEmployeeProfileService(userId: number) {
    this.reimburementService.EmployeeProfileService(userId).subscribe(
      (response) => {
        this.newUser = response;
      },
      (error) => {
        this.errorMsg = 'There was some internal error! Please try again later!';
      }
    )
  }

  editProf() {
    this.router.navigate(['/user-update-profile', this.newUser.id]);
  }

}


