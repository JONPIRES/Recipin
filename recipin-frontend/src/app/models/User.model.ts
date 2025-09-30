export interface User {
  id?: number;
  firstName?: string;
  lastName?: string;
  name?: string; // For backward compatibility
  password?: string;
  email?: string;
}
