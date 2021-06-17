import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ShippingRegionComponent } from './shipping-region.component';

describe('ShippingRegionComponent', () => {
  let component: ShippingRegionComponent;
  let fixture: ComponentFixture<ShippingRegionComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ShippingRegionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShippingRegionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
