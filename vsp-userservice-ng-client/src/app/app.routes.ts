import { Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {HealthComponent} from "./health/health.component";

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'health', component: HealthComponent },
  // Add more routes as needed
];
