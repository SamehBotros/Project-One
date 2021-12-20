import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './Components/users/login/login.component';
import { RequestComponent } from './Components/reimbursment/request/request.component';
import { SignupComponent } from './Components/users/signup/signup.component';
import { UpdateProfileComponent } from './Components/reimbursment/update-profile/update-profile.component';
import { LogoutComponent } from './Components/users/logout/logout.component';
import { ApproveRequestComponent } from './Components/reimbursment/approve-request/approve-request.component';
import { HomeComponent } from './Components/home/home.component';
import { AllResolvedRequestComponent } from './Components/reimbursment/all-resolved-request/all-resolved-request.component';
import { SpecificRequestComponent } from './Components/reimbursment/specific-request/specific-request.component';
import { UserPendingRequestComponent } from './Components/reimbursment/user-pending-request/user-pending-request.component';
import { UserResolvedRequestComponent } from './Components/reimbursment/user-resolved-request/user-resolved-request.component';
import { UserProfileComponent } from './Components/reimbursment/user-profile/user-profile.component';
import { AllPendingRequestComponent } from './Components/reimbursment/all-pending-request/all-pending-request.component';
import { AdminGuard } from './Components/users/admin.guard';
import { SpacificDisplayComponent } from './Components/reimbursment/spacific-display/spacific-display.component';
import { AllEmployeeComponent } from './Components/reimbursment/all-employee/all-employee.component';
import { RegestRefreshPageComponent } from './Components/users/regest-refresh-page/regest-refresh-page.component';
import { SoryMessageComponent } from './Components/reimbursment/sory-message/sory-message.component';
import { RequestMessageComponent } from './Components/reimbursment/request-message/request-message.component';
import { ShowReceiptComponent } from './Components/reimbursment/show-receipt/show-receipt.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'request',
    component: RequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'signup',
    component: SignupComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'update-profile',
    component: UpdateProfileComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'logout',
    component: LogoutComponent
  }, {
    path: 'approve-request',
    component: ApproveRequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'user-update-profile/:sentUserId',
    component: UpdateProfileComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'all-Pending-Request',
    component: AllPendingRequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'all-resolved-request',
    component: AllResolvedRequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'specific-request',
    component: SpecificRequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'user-pending-request',
    component: UserPendingRequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'user-resolved-request',
    component: UserResolvedRequestComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'user-profile',
    component: UserProfileComponent,
    canActivate: [AdminGuard]
  }, {
    path: 'user-specific-Display/:sentUserid',
    component: SpacificDisplayComponent
  }, {
    path: 'all-employee',
    component: AllEmployeeComponent
  }, {
    path: 'thanks-message',
    component: RegestRefreshPageComponent
  }, {
    path: 'sorry-message',
    component: SoryMessageComponent
  }, {
    path: 'request-message',
    component: RequestMessageComponent
  }, {
    path: 'show_receipt',
    component: ShowReceiptComponent
  }





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],

})
export class AppRoutingModule { }
