import { TestBed } from '@angular/core/testing';

import { ShippingsService } from './shippings.service';

describe('ShippingsService', () => {
  let service: ShippingsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShippingsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
