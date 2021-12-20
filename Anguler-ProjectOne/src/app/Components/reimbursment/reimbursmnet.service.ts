import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserModel } from './users.model';
import { RequestModel } from './request.model';


@Injectable({ providedIn: 'root' })
export class ReimbursmnetService {

  addRequestUrl = "http://localhost:4040/api/request";
  usersUrl = "http://localhost:4040/api/users";
  requestUrl = "http://localhost:4040/api/request/pending";
  resolveUrl = "http://localhost:4040/api/request/resolve";
  approveUrl = "http://localhost:4040/api/request";
  userResolve = "http://localhost:4040/api/request/resolve";
  spacificUrl = "http://localhost:4040/api/request/spacific";
  userPending = " http://localhost:4040/api/request/pend";
  allEmployee = "http://localhost:4040/api/users/employee";
  userLogin = "http://localhost:4040/api/users/login";
  userProfile = "http://localhost:4040/api/users/profile";
  rejectUrl = "http://localhost:4040/api/request/reject";
  getUserByName = "http://localhost:4040/api/users/byusername";
  userUpdate = "http://localhost:4040/api/users/update";
  registerUrl = " http://localhost:4040/api/users/register";

  constructor(private http: HttpClient) { }

  // use Observable when you add or update
  addRequestService(newRequest: RequestModel): Observable<RequestModel> {
    return this.http.post<RequestModel>(this.addRequestUrl, newRequest);
  }

  loadUserInfoService(userId: number): Observable<UserModel> {
    return this.http.get<UserModel>(this.usersUrl + "/" + userId);
  }

  removeUserService(userId: number): Observable<UserModel[]> {
    return this.http.delete<UserModel[]>(this.usersUrl + "/" + userId);

  }
  UserPendingRequestService(userId: number): Observable<RequestModel[]> {
    return this.http.get<RequestModel[]>(this.userPending + "/" + userId);

  }
  UserResolveRequestService(userId: number): Observable<RequestModel[]> {
    return this.http.get<RequestModel[]>(this.userResolve + "/" + userId);
  }
  EmployeeProfileService(userId: number): Observable<UserModel> {
    return this.http.get<UserModel>(this.userProfile + "/" + userId);

  }
  updateUserInfoService(updateUser: UserModel): Observable<UserModel> {
    return this.http.put<UserModel>(this.userUpdate + "/" + updateUser.id, updateUser);
  }
  allPendingRequstsService() {
    return this.http.get<RequestModel[]>(this.requestUrl);
  }
  AllResolvedRequstService() {
    return this.http.get<RequestModel[]>(this.resolveUrl);
  }
  SpacificEmployeeService(reqId: number) {
    return this.http.get<RequestModel[]>(this.spacificUrl + "/" + reqId);
  }
  approveRequestService(reqId: number) {
    return this.http.patch<RequestModel>(this.approveUrl + "/" + reqId, RequestModel);
  }
  rejectRequestService(reqId: number) {
    return this.http.patch<RequestModel>(this.rejectUrl + "/" + reqId, RequestModel);
  }
  getUserByNameService(userName: UserModel): Observable<UserModel> {
    return this.http.post<UserModel>(this.getUserByName, userName);
  }
  validataLoginService(logUser: UserModel): Observable<UserModel> {
    return this.http.post<UserModel>(this.userLogin, logUser);
  }
  registrationService(addUser: UserModel): Observable<UserModel> {
    return this.http.post<UserModel>(this.registerUrl, addUser);
  }
  allEmployeeService() {
    return this.http.get<UserModel[]>(this.allEmployee);


  }


}
