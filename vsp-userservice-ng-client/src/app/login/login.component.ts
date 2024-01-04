import {Component, Inject, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {Router} from "@angular/router";
import {AngularFireAuth} from "@angular/fire/compat/auth";
import * as auth from 'firebase/auth';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  email: string | undefined;
  password: string | undefined;
  constructor(private ngFireAuth: AngularFireAuth,  public router: Router) { }
  ngOnInit() {
  }
  login(email?: string, password?: string) {
    if(email && password){
 //   this.authService.signIn(email, password).then(/* handle success */).catch(/* handle error */);
    }
  }

  onSubmit() {
    this.login(this.email, this.password);
  }

  GoogleAuth() {
    return this.authLogin(new auth.GoogleAuthProvider());
  }

  authLogin(provider: any) {
    return this.ngFireAuth
      .signInWithPopup(provider)
      .catch((error) => {
        window.alert(error);
      });
  }
  // Sign up method
  signUp(email: string, password: string) {
    return this.ngFireAuth.createUserWithEmailAndPassword(email, password);
  }

  // Sign in method
  signIn(email: string, password: string) {
    return this.ngFireAuth.signInWithEmailAndPassword(email, password);
  }

  // Sign out method
  signOut() {
    return this.ngFireAuth.signOut();
  }
}
