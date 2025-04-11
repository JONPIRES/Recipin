import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models';

@Injectable({
  providedIn: 'root',
})
export class AuthApiService {
  constructor(private http: HttpClient) {}

  isAuthenticated(): boolean {
    const token = localStorage.getItem('authToken');
    return token != null;
  }

  authenticate(user: User): Observable<User> {
    if (this.isAuthenticated()) {
      return new Observable((observer) => {
        observer.next({ email: user.email, id: 1 });
        observer.complete();
      });
    }
    return this.http.post<any>('/api/auth/login', { user });
  }

  register(user: User): Observable<any> {
    return this.http.post('/api/user', user);
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
