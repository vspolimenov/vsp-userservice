import {Component, OnInit} from '@angular/core';
import {ApiService} from "../services/api.service";
import {HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-health',
  standalone: true,
  templateUrl: './health.component.html',
  styleUrl: './health.component.css',
  imports: [HttpClientModule]
})
export class HealthComponent implements OnInit {
  exampleData: any | undefined;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.getExampleData().subscribe(data => {
      this.exampleData = data;
    });
  }
}
