
export interface Product {
  id?: number;
  name?: string;
  description?: string;
  price?: number;
  discountedPrice?: number;
  image?: string;
  thumbnail?: string;
  display?: number;
  categories?: /*Category*/[];
  reviews?: /*Review*/[];
  shoppingCarts?: /*ShoppingCart*/[];
}
