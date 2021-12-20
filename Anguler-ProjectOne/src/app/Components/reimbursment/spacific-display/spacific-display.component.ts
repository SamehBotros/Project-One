import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ReimbursmnetService } from '../reimbursmnet.service';
import { RequestModel } from '../request.model';
import { Router } from '@angular/router';


@Component({ selector: 'app-spacific-display', templateUrl: './spacific-display.component.html', styleUrls: ['./spacific-display.component.css'] })
export class SpacificDisplayComponent implements OnInit {
  errorMsg: string = "";
  newRequest: RequestModel[] = [];

  constructor(private reimbursmnetService: ReimbursmnetService, private activatedRoute: ActivatedRoute, private router: Router) { }


  ngOnInit(): void {
    var id: any = this.activatedRoute.snapshot.paramMap.get("sentUserid");
    this.reimbursmnetService.SpacificEmployeeService(id).subscribe((response) => {
      this.newRequest = response;
      // Sort descending
      this.newRequest.sort((a, b) => a.id - b.id);
    }, (error) => {
      this.errorMsg = 'There was some internal error! Please try again later!';
    })
  }

}
