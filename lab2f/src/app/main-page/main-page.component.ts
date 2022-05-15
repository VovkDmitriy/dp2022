import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Insect } from '../interfaces/insect';
import { Service1Service } from '../services/service1.service';


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  insectList:Insect[]= [];

  constructor(private service:Service1Service, private router: Router){}

  getInsects():void{
    this.service.getInsects().subscribe(
      (insects)=>{
        this.insectList = insects;
      }
    )
  }


  ngOnInit(): void {
  }

}
