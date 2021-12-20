import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoryMessageComponent } from './sory-message.component';

describe('SoryMessageComponent', () => {
  let component: SoryMessageComponent;
  let fixture: ComponentFixture<SoryMessageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SoryMessageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SoryMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
