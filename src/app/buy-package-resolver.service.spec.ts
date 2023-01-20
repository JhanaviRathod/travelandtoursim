import { TestBed } from '@angular/core/testing';

import { BuyPackageResolverService } from './buy-package-resolver.service';

describe('BuyPackageResolverService', () => {
  let service: BuyPackageResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BuyPackageResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
