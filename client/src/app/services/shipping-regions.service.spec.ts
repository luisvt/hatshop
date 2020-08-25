import { TestBed } from '@angular/core/testing';

import { ShippingRegionsService } from './shipping-regions.service';

describe('ShippingRegionsService', () => {
  let service: ShippingRegionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShippingRegionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
