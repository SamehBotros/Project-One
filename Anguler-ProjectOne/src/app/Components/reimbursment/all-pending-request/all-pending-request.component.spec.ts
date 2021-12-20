import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPendingRequestComponent } from './all-pending-request.component';

describe('AllPendingRequestComponent', () => {
  let component: AllPendingRequestComponent;
  let fixture: ComponentFixture<AllPendingRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllPendingRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllPendingRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
