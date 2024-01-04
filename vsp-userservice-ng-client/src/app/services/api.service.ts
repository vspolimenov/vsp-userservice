import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/users'; // URL to web api

  constructor(private http: HttpClient) { }

  getExampleData(): Observable<any> {
    console.log("here")
    return this.http.get(this.apiUrl + '/health');
  }
}
