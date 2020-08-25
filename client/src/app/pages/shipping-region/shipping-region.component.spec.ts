import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShippingRegionComponent } from './shipping-region.component';

describe('ShippingRegionComponent', () => {
  let component: ShippingRegionComponent;
  let fixture: ComponentFixture<ShippingRegionComponent>;

  beforeEach(async(() => {
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
