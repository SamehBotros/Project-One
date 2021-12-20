import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Components/users/login/login.component';
import { RequestComponent } from './Components/reimbursment/request/request.component';
import { UpdateProfileComponent } from './Components/reimbursment/update-profile/update-profile.component';
import { SignupComponent } from './Components/users/signup/signup.component';
import { HeaderComponent } from './Components/header/header.component';
import { ApproveRequestComponent } from './Components/reimbursment/approve-request/approve-request.component';
import { LogoutComponent } from './Components/users/logout/logout.component';
import { HomeComponent } from './Components/home/home.component';
import { AllResolvedRequestComponent } from './Components/reimbursment/all-resolved-request/all-resolved-request.component';
import { SpecificRequestComponent } from './Components/reimbursment/specific-request/specific-request.component';
import { UserPendingRequestComponent } from './Components/reimbursment/user-pending-request/user-pending-request.component';
import { UserResolvedRequestComponent } from './Components/reimbursment/user-resolved-request/user-resolved-request.component';
import { UserProfileComponent } from './Components/reimbursment/user-profile/user-profile.component';
import { AllPendingRequestComponent } from './Components/reimbursment/all-pending-request/all-pending-request.component';
import { HttpClientModule } from '@angular/common/http';
import { SpacificDisplayComponent } from './Components/reimbursment/spacific-display/spacific-display.component';
import { AllEmployeeComponent } from './Components/reimbursment/all-employee/all-employee.component';
import { RegestRefreshPageComponent } from './Components/users/regest-refresh-page/regest-refresh-page.component';
import { SoryMessageComponent } from './Components/reimbursment/sory-message/sory-message.component';
import { RequestMessageComponent } from './Components/reimbursment/request-message/request-message.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { ShowReceiptComponent } from './Components/reimbursment/show-receipt/show-receipt.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RequestComponent,
    UpdateProfileComponent,
    SignupComponent,
    HeaderComponent,
    LogoutComponent,
    ApproveRequestComponent,
    HomeComponent,
    AllResolvedRequestComponent,
    SpecificRequestComponent,
    UserPendingRequestComponent,
    UserResolvedRequestComponent,
    UserProfileComponent,
    AllPendingRequestComponent,
    SpacificDisplayComponent,
    AllEmployeeComponent,
    RegestRefreshPageComponent,
    SoryMessageComponent,
    RequestMessageComponent,
    ShowReceiptComponent,

  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    // add to work with a validation form insted of templet form
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    NoopAnimationsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  // for dynamic component

})
export class AppModule { }
