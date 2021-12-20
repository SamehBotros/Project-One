import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecificRequestComponent } from './specific-request.component';

describe('SpecificRequestComponent', () => {
  let component: SpecificRequestComponent;
  let fixture: ComponentFixture<SpecificRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecificRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecificRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
