import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private router: Router) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // Get the auth token from localStorage
    const authToken = localStorage.getItem('authToken');
    
    // Clone the request and add the authorization header if token exists
    if (authToken) {
      const authRequest = request.clone({
        setHeaders: {
          Authorization: `Bearer ${authToken}`
        }
      });
      
      return next.handle(authRequest).pipe(
        catchError((error: HttpErrorResponse) => {
          // Handle 401 Unauthorized responses
          if (error.status === 401) {
            // Token is invalid or expired
            localStorage.removeItem('authToken');
            this.router.navigate(['/login']);
          }
          
          // Handle 403 Forbidden responses
          if (error.status === 403) {
            // User doesn't have permission
            console.error('Access denied: Insufficient permissions');
          }
          
          return throwError(() => error);
        })
      );
    }
    
    // If no token, proceed with the original request
    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        // Handle 401 Unauthorized responses even without token
        if (error.status === 401) {
          this.router.navigate(['/login']);
        }
        
        return throwError(() => error);
      })
    );
  }
}
