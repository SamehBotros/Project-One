import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserModel } from '../users.model';
import { AuthService } from '../../users/auth.service';

@Component({ selector: 'app-update-profile', templateUrl: './update-profile.component.html', styleUrls: ['./update-profile.component.css'] })
export class UpdateProfileComponent implements OnInit {
  theUserId: number | undefined;
  newUser: UserModel = new UserModel();
  errorMsg: string = "";


  constructor(private reimburementService: ReimbursmnetService, private activatedRoute: ActivatedRoute, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    var receivedUserId: any = this.activatedRoute.snapshot.paramMap.get("sentUserId");
    this.reimburementService.EmployeeProfileService(receivedUserId).subscribe((response) => {
      this.newUser = response;
      this.theUserId = response.id;
    }, (error) => {
      this.errorMsg = 'There was some enternal error!  Please try again later!';
    });
  }

  updateUserInfo() {
    this.reimburementService.updateUserInfoService(this.newUser).subscribe((response) => {
      this.newUser = response;
      this.router.navigate(['/user-profile']);
    }, (error) => {
      this.errorMsg = 'There was some enternal error!  Please try again later!';
    })
  }


}
