import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap, catchError, throwError } from 'rxjs';
import { User } from '../models';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthApiService {
  constructor(private http: HttpClient) {}

  isAuthenticated(): boolean {
    const token = localStorage.getItem('authToken');
    return token != null && !this.isTokenExpired(token);
  }

  private isTokenExpired(token: string): boolean {
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.exp < Date.now() / 1000;
    } catch {
      return true;
    }
  }

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/auth/login`, { email, password }).pipe(
      tap(response => {
        if (response.token) {
          localStorage.setItem('authToken', response.token);
        }
      }),
      catchError(error => {
        console.error('Login error:', error);
        return throwError(() => error);
      })
    );
  }

  register(user: User): Observable<any> {
    return this.http.post(`${environment.apiUrl}/auth/register`, user).pipe(
      catchError(error => {
        console.error('Registration error:', error);
        return throwError(() => error);
      })
    );
  }

  logout(): void {
    localStorage.removeItem('authToken');
  }

  getCurrentUser(): User | null {
    const token = localStorage.getItem('authToken');
    if (token && !this.isTokenExpired(token)) {
      try {
        const payload = JSON.parse(atob(token.split('.')[1]));
        return {
          id: payload.sub,
          email: payload.email,
          name: payload.name
        };
      } catch {
        return null;
      }
    }
    return null;
  }

  // decodeToken(token: string): any {
  //   try {
  //     return jwt_decode(token);
  //   } catch (e) {
  //     console.error('Token decoding failed:', e);
  //     return null;
  //   }
  // }
}
