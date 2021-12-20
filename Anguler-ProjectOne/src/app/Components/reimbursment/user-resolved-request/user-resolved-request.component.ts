import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../users/auth.service';
import { User } from '../../users/users.model';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { RequestModel } from '../request.model';

@Component({ selector: 'app-user-resolved-request', templateUrl: './user-resolved-request.component.html', styleUrls: ['./user-resolved-request.component.css'] })
export class UserResolvedRequestComponent implements OnInit {

  errorMsg: string = "";
  requestForm: RequestModel[] = [];

  constructor(private reimbursmnetService: ReimbursmnetService, private authService: AuthService) { }

  ngOnInit(): void {
    var data: User = this.authService.getUser();
    this.userResolveRequest(data.id);
  }

  userResolveRequest(userId: number) {
    this.reimbursmnetService.UserResolveRequestService(userId).subscribe((response) => {
      this.requestForm = response;
      // Sort descending
      this.requestForm.sort((a, b) => a.id - b.id);
    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }

}
