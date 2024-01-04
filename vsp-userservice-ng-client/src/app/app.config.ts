import {ApplicationConfig, importProvidersFrom} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideHttpClient} from "@angular/common/http";
import {AppModule} from "./app.module";
import {environment} from "../environments/environment";
import firebase from "firebase/compat";
import initializeApp = firebase.initializeApp;
import {provideFirebaseApp} from "@angular/fire/app";

export const appConfig: ApplicationConfig = {
  providers: [ provideHttpClient()
    ,provideRouter(routes),
   /* importProvidersFrom(AppModule)*/]
};
