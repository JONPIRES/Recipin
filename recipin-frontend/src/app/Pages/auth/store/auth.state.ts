import { HttpErrorResponse } from '@angular/common/http';
import { Action, Selector, State, StateContext } from '@ngxs/store';
import { catchError, of, tap } from 'rxjs';
import { AuthApiService } from 'src/app/api-services/auth-api.service';
import { User } from 'src/app/models';
import { LoadUser } from './auth.actions';

export interface AuthStateModel {
  user: User | null;
}

@State<AuthStateModel>({
  name: 'recipe',
  defaults: {
    user: null,
  },
})
export class AuthState {
  constructor(private authApi: AuthApiService) {}

  @Selector()
  static getUser(state: AuthStateModel): User | null {
    return state.user;
  }

  @Action(LoadUser)
  loadUser(
    { patchState, setState }: StateContext<AuthStateModel>,
    { payload: { user } }: LoadUser
  ): void {
    if (user?.email && user.password) {
      // use the auth service for autentication and return the user with a token?
      this.authApi.authenticate(user).pipe(
        tap((resUser) => {
          setState({ user: resUser });
        }),
        catchError((e: HttpErrorResponse) => {
          return of(e);
        })
      );
    }
  }
}
