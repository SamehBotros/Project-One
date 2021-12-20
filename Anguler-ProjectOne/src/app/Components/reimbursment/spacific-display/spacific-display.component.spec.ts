import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpacificDisplayComponent } from './spacific-display.component';

describe('SpacificDisplayComponent', () => {
  let component: SpacificDisplayComponent;
  let fixture: ComponentFixture<SpacificDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpacificDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpacificDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
