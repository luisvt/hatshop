import { Role } from './role';

export interface User {
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  authorities: Role[];
  accountNonExpired: boolean,
  accountNonLocked: boolean,
  credentialsNonExpired: boolean,
  enabled: boolean
}
