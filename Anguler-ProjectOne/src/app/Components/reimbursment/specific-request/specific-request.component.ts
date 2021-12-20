import { Component, OnInit } from '@angular/core';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { RequestModel } from '../request.model';
import { UserModel } from '../users.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-specific-request',
  templateUrl: './specific-request.component.html',
  styleUrls: ['./specific-request.component.css']
})
export class SpecificRequestComponent implements OnInit {

  errorMsg: string = "";
  myRequestModel: RequestModel = new RequestModel();
  UserModel: UserModel = new UserModel();

  constructor(private reimbursmnetService: ReimbursmnetService, private router: Router) { }

  ngOnInit(): void { }

  getuser() {
    this.reimbursmnetService.getUserByNameService(this.UserModel).subscribe(
      (response) => {
        let theUserId: number = response.id;
        console.log(response)
        if (theUserId == 0) {
          this.router.navigate(['/sorry-message']);
        } else {
          //Routing Parameters
          this.router.navigate(['/user-specific-Display', theUserId]);
        }
      },
      (error) => {
        this.errorMsg = 'There was some enternal error!  Please try again later!';
      }
    )
  }


}
