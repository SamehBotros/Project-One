import { TestBed } from '@angular/core/testing';

import { AllStaffServices } from './users.service';

describe('ServiceService', () => {
  let service: AllStaffServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllStaffServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
