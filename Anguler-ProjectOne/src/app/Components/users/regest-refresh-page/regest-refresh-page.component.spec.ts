import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegestRefreshPageComponent } from './regest-refresh-page.component';

describe('RegestRefreshPageComponent', () => {
  let component: RegestRefreshPageComponent;
  let fixture: ComponentFixture<RegestRefreshPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegestRefreshPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegestRefreshPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
