import { TestBed } from '@angular/core/testing';

import { ReimbursmnetService } from './reimbursmnet.service';

describe('ReimbursmnetService', () => {
  let service: ReimbursmnetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReimbursmnetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
