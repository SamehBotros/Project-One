import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllResolvedRequestComponent } from './all-resolved-request.component';

describe('AllResolvedRequestComponent', () => {
  let component: AllResolvedRequestComponent;
  let fixture: ComponentFixture<AllResolvedRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllResolvedRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllResolvedRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
