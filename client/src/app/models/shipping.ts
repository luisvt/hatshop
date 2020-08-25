import { ShippingRegion } from './shipping-region';

export interface Shipping {
  id: number;
  shippingType: string;
  shippingCost: number;
  shippingRegion: ShippingRegion;
}
