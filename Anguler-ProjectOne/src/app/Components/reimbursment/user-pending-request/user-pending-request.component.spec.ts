import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPendingRequestComponent } from './user-pending-request.component';

describe('UserPendingRequestComponent', () => {
  let component: UserPendingRequestComponent;
  let fixture: ComponentFixture<UserPendingRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserPendingRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPendingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
