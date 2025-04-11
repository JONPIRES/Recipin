import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthApiService } from 'src/app/api-services/auth-api.service';
import { SharedModule } from 'src/app/shared/shared.module';

@Component({
  selector: 'app-register',
  imports: [SharedModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent implements OnInit {
  constructor(private fb: FormBuilder, private authApi: AuthApiService) {}

  registerForm: FormGroup = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]],
  });

  onSubmit() {
    if (this.registerForm.valid) {
      this.authApi.register(this.registerForm.value).subscribe({
        next: (res) => console.log('User registered:', res),
        error: (err) => console.error('Registration error:', err),
      });
    }
  }

  ngOnInit(): void {}
}
