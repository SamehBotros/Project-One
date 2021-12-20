import { Component, OnInit, NgModule, TemplateRef } from '@angular/core';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { RequestModel } from '../request.model';
import { Router } from '@angular/router';



@Component({ selector: 'app-all-pending-request', templateUrl: './all-pending-request.component.html', styleUrls: ['./all-pending-request.component.css'] })
export class AllPendingRequestComponent implements OnInit {

  newRequest: RequestModel[] = [];
  temp: RequestModel = new RequestModel();
  errorMsg: string = "";
  constructor(private reimbursmnetService: ReimbursmnetService, private router: Router) { }

  ngOnInit(): void {
    this.viewallPendingRequest();
  }

  viewallPendingRequest() {
    this.reimbursmnetService.allPendingRequstsService().subscribe((response) => {
      this.newRequest = response;
      // Sort descending
      this.newRequest.sort((a, b) => a.id - b.id);
    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }
  showimg(imgReq: RequestModel) {
    this.router.navigate(['/user-specific-Display', imgReq]);

  }

}
