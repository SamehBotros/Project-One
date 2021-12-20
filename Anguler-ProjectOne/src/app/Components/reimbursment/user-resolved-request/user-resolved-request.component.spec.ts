import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserResolvedRequestComponent } from './user-resolved-request.component';

describe('UserResolvedRequestComponent', () => {
  let component: UserResolvedRequestComponent;
  let fixture: ComponentFixture<UserResolvedRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserResolvedRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserResolvedRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
