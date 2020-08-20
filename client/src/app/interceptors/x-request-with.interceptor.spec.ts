import { TestBed } from '@angular/core/testing';

import { XRequestWithInterceptor } from './x-request-with.interceptor';

describe('XhrInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      XRequestWithInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: XRequestWithInterceptor = TestBed.inject(XRequestWithInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
