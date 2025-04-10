import { User } from 'src/app/models';

export class LoadUser {
  static readonly type = '[Auth] User Sign In';
  constructor(public payload: { user: User }) {}
}

export class CreateUser {
  static readonly type = '[Auth] Create User';
  constructor(public payload: User) {}
}

export class UpdateUser {
  static readonly type = '[Auth] Update User';
  constructor(public payload: User) {}
}

export class DeleteUser {
  static readonly type = '[Auth] Delete User';
  constructor(public payload: User['id']) {}
}
