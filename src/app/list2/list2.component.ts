import { Component, OnInit } from '@angular/core';
import { IInsect } from '../interfaces/insect';
import { InsectService } from '../services/insect.service';

@Component({
  selector: 'app-list2',
  templateUrl: './list2.component.html',
  styleUrls: ['./list2.component.scss']
})

export class List2Component implements OnInit {

  insectsList:IInsect[]=[]

  constructor(private service:InsectService) { }

  ngOnInit(): void {
    this.service.list.subscribe(
      (list:IInsect[])=>{this.insectsList=list}
    )
  }

}
