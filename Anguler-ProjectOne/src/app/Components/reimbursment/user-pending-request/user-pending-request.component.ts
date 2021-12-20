import { User } from './../../users/users.model';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../users/auth.service';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { RequestModel } from '../request.model';
import { UserModel } from '../users.model';

@Component({ selector: 'app-user-pending-request', templateUrl: './user-pending-request.component.html', styleUrls: ['./user-pending-request.component.css'] })
export class UserPendingRequestComponent implements OnInit {

  errorMsg: string = "";
  dateNow: Date = new Date();
  lccaldate: string = new Date().toLocaleString();

  constructor(private reimbursmnetService: ReimbursmnetService, private authService: AuthService) { }
  requestForm: RequestModel[] = [];

  ngOnInit(): void {
    var data: User = this.authService.getUser();
    this.viewUserPending(data.id);
  }

  viewUserPending(userId: number) {
    this.reimbursmnetService.UserPendingRequestService(userId).subscribe((response) => {
      this.requestForm = response;
      // Sort descending
      this.requestForm.sort((a, b) => a.id - b.id);
    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }

}
