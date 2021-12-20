import { Component, Inject, OnInit, Optional } from '@angular/core';
import { RequestModel } from '../request.model';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


@Component({
  selector: 'app-show-receipt',
  templateUrl: './show-receipt.component.html',
  styleUrls: ['./show-receipt.component.css']
})
export class ShowReceiptComponent implements OnInit {

  myRequestModel: RequestModel = new RequestModel();
  action: any;

  constructor(
    public dialogRef: MatDialogRef<ShowReceiptComponent>,
    //@Optional() is used to prevent error if no data is passed
    @Optional() @Inject(MAT_DIALOG_DATA) public data: RequestModel) {
    //this data sent from approve request component
    this.action = data.img;

  }

  ngOnInit(): void {

  }


  close() {
    this.dialogRef.close();
  }

}
