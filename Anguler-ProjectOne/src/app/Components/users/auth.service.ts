import { UsersData } from './userData';
import { Injectable } from '@angular/core';
import { UserModel } from '../reimbursment/users.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  [x: string]: any;

  isLoggedIn: boolean = false
  sessionStorage: any;

  //if the user login store his information
  storeUser(user: UserModel) {
    //Json.stringful to convert user to string
    sessionStorage.setItem("userData", JSON.stringify(user));

  }

  getUser() {
    //const data: any = JSON.parse(this.sessionStorage.getItem('userData'))
    var data: any = sessionStorage.getItem("userData")
    //Json.parse to convert user to an object
    return JSON.parse(data == null ? '' : data);
  }

  //if the user logout remove information
  removeUser() {
    sessionStorage.removeItem("userData");
  }
  // use it for welcome
  retrieveUserType() {
    let data: any = sessionStorage.getItem("userData")
    let user: UserModel = JSON.parse(data == null ? '' : data);
    return user.usertype_id;
  }

  retrieveUserId() {
    let data: any = sessionStorage.getItem("userData")
    let user: UserModel = JSON.parse(data == null ? '' : data);
    return user.id;
  }


}
