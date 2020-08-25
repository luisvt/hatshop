import { Shipping } from './shipping';

export interface ShippingRegion {
  id: number;
  shippingRegion: string;
  shippings: Shipping[];
}
