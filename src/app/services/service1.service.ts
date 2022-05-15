import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Insect } from '../interfaces/insect';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  url:string = "http://localhost:8012/lab2/Servlet1";

  constructor(private http:HttpClient) { }

    getInsects():Observable<Insect[]>{
      return this.http.get<Insect[]>(this.url);
    }
  
}
function getInsects() {
  throw new Error('Function not implemented.');
}