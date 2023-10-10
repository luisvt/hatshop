import { Role } from './role';

export interface User {
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  roles: Role[];
  accountNonExpired: boolean,
  accountNonLocked: boolean,
  credentialsNonExpired: boolean,
  enabled: boolean
}
