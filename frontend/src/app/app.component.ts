import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

interface HelloResponse {
  message: string;
  version: string;
  env: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  title = 'CSP Demo';
  hello: HelloResponse | null = null;
  error: string | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<HelloResponse>('/hello').subscribe({
      next:  (data) => this.hello = data,
      error: ()     => this.error = 'Backend not available — running standalone'
    });
  }
}
