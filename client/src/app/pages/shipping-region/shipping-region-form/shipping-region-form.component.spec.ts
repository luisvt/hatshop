import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShippingRegionFormComponent } from './shipping-region-form.component';

describe('ShippingRegionFormComponent', () => {
  let component: ShippingRegionFormComponent;
  let fixture: ComponentFixture<ShippingRegionFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShippingRegionFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShippingRegionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
