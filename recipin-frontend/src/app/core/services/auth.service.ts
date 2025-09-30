import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from '../../models';
import { AuthApiService } from '../../api-services/auth-api.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSubject = new BehaviorSubject<User | null>(null);
  public currentUser$ = this.currentUserSubject.asObservable();

  constructor(private authApiService: AuthApiService) {
    // Initialize with current user if token exists
    this.initializeAuth();
  }

  private initializeAuth(): void {
    const user = this.authApiService.getCurrentUser();
    this.currentUserSubject.next(user);
  }

  login(email: string, password: string): Observable<any> {
    return this.authApiService.login(email, password).pipe(
      tap(response => {
        const user = this.authApiService.getCurrentUser();
        this.currentUserSubject.next(user);
      })
    );
  }

  register(user: User): Observable<any> {
    return this.authApiService.register(user);
  }

  logout(): void {
    this.authApiService.logout();
    this.currentUserSubject.next(null);
  }

  isAuthenticated(): boolean {
    return this.authApiService.isAuthenticated();
  }

  getCurrentUser(): User | null {
    return this.currentUserSubject.value;
  }
}
