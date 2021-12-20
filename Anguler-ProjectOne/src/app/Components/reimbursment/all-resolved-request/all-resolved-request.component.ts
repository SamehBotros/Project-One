import { ReimbursmnetService } from './../reimbursmnet.service';
import { Component, OnInit } from '@angular/core';
import { RequestModel } from '../request.model';

@Component({ selector: 'app-all-resolved-request', templateUrl: './all-resolved-request.component.html', styleUrls: ['./all-resolved-request.component.css'] })
export class AllResolvedRequestComponent implements OnInit {

  errorMsg: string = "";
  newRequest: RequestModel[] = [];

  constructor(private reimbursmnetService: ReimbursmnetService) { }

  ngOnInit(): void {
    this.viewAllResolved();
  }

  viewAllResolved() {
    this.reimbursmnetService.AllResolvedRequstService().subscribe((response) => {
      this.newRequest = response;
      // Sort descending
      this.newRequest.sort((a, b) => a.id - b.id);
    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }

}
