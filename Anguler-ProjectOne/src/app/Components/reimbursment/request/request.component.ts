import { ReimbursmnetService } from './../reimbursmnet.service';
import { Component, OnInit } from '@angular/core';
import { RequestModel } from '../request.model';
import { AuthService } from '../../users/auth.service';
import { UserModel } from '../users.model';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';


@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
  requestForm: RequestModel = new RequestModel();

  flag: boolean = false;
  errorMsg: string = "";

  today: Date = new Date();
  dd = String(this.today.getDate()).padStart(2, '0');
  mm = String(this.today.getMonth() + 1).padStart(2, '0'); //January is 0!
  yyyy = this.today.getFullYear();
  dateNow: string = this.yyyy + '/' + this.mm + '/' + this.dd;

  constructor(private reimbursmnetService: ReimbursmnetService, private authService: AuthService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void { }

  addRequest() {
    var data: UserModel = this.authService.getUser();
    this.requestForm.users_id = data.id;
    this.requestForm.req_date = this.dateNow;
    this.reimbursmnetService.addRequestService(this.requestForm).subscribe((response) => {
      this.requestForm = response;
      this.router.navigate(['/request-message']);
    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }

}
