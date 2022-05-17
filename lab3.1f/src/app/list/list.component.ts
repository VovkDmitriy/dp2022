import { Component, OnInit } from '@angular/core';
import { IInsect } from '../interfaces/insect';
import { InsectService } from '../services/insect.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  title:string="List of Insects";
  insectsList:IInsect[]=[];
  showAddForm:boolean=false;
  selectedInsect?:IInsect;


  constructor(private service:InsectService) { }

  ngOnInit(): void {
    this.updateInsects();
  }

  updateInsects(){
    this.service.getInsect().subscribe(
      (insects)=>{
        this.insectsList=insects;
        this.service.setList(insects);
      }
    );
  }

  addInsect(insect:IInsect){
    this.service.postInsect(insect).subscribe(
      ()=>{
        // console.log(user);
        this.updateInsects();
      }
    );
  }

  onSelect(insect:IInsect){
    console.log(insect);
    if(this.selectedInsect && insect.id==this.selectedInsect.id){
      this.selectedInsect=undefined;
    } else {
      this.selectedInsect=insect;
    }
  }

  deleteInsect(insect:IInsect){
    this.service.deleteInsect(insect).subscribe(
      ()=>{
        this.updateInsects();
      }
    );
  }

}
