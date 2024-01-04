// import {Inject, Injectable, NgZone} from '@angular/core';
// import * as auth from 'firebase/auth';
// import { Router } from '@angular/router';
// import { AngularFireAuth } from '@angular/fire/compat/auth';
// import {AngularFirestore} from "@angular/fire/compat/firestore";
//
// @Injectable({
//   providedIn: 'root',
// })
// export class AuthenticationService {
//   userData: any;
//   userToken: string | null = null; // Store the user token here
//   constructor( @Inject(AngularFireAuth) public ngFireAuth: AngularFireAuth) {
//     this.ngFireAuth.authState.subscribe((user) => {
//       console.log("loging problem...")
//       if (user) {
//
//         this.userData = user;
//         if (user.emailVerified) {
//           user.getIdToken().then(token => {
//             this.userToken = token;
//           });
//         }
//       } else {
//       }
//     });
//   }
//
//   // GoogleAuth() {
//   //   return this.authLogin(new auth.GoogleAuthProvider());
//   // }
//   //
//   // authLogin(provider: any) {
//   //   return this.afAuth
//   //     .signInWithPopup(provider)
//   //     .catch((error) => {
//   //       window.alert(error);
//   //     });
//   // }
//   // // Sign up method
//   // signUp(email: string, password: string) {
//   //   return this.afAuth.createUserWithEmailAndPassword(email, password);
//   // }
//   //
//   // // Sign in method
//   // signIn(email: string, password: string) {
//   //   return this.afAuth.signInWithEmailAndPassword(email, password);
//   // }
//   //
//   // // Sign out method
//   // signOut() {
//   //   return this.afAuth.signOut();
//   // }
// }
