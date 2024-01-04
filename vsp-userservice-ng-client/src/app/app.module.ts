import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AngularFireAuthModule } from '@angular/fire/compat/auth';
import { environment } from '../environments/environment';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {provideFirebaseApp} from "@angular/fire/app";
import firebase from "firebase/compat";
import initializeApp = firebase.initializeApp;
import {AngularFireModule} from "@angular/fire/compat";

@NgModule({

  imports: [
    BrowserModule,// Correctly import RouterModule
    HttpClientModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireAuthModule
  ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA] // This is fine to keep
})
export class AppModule { }
