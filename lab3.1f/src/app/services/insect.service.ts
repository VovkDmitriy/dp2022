import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { IInsect } from '../interfaces/insect';

@Injectable({
  providedIn: 'root'
})
export class InsectService {

  list = new BehaviorSubject<IInsect[]>([])
  //url:string="http://localhost:3000/insects"
  url:string="http://localhost:8016/lab3.1b/Servlet1"
  //INSECTS:IInsect[]=[{id:1, title:"Insect 1", age:4, desc: "one"},{id:1, title:"Insect 2", age: 2, desc: "two"}]

  constructor(private http:HttpClient) { }

  getInsect():Observable<IInsect[]>{
    return this.http.get<IInsect[]>(this.url);
  }

  postInsect(insect:IInsect):Observable<IInsect[]>{
    return this.http.post<IInsect[]>(this.url,insect);
  }

  putInsect(insect:IInsect):Observable<IInsect[]>{
    return this.http.put<IInsect[]>(this.url+"/"+insect.id,insect);
  }

  deleteInsect(insect:IInsect):Observable<IInsect[]>{
    return this.http.delete<IInsect[]>(this.url+"/"+insect.id);
  }

  setList(list:IInsect[]){
    this.list.next(list);
  }


}
