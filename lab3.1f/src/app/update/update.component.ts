import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IInsect } from '../interfaces/insect';
import { InsectService } from '../services/insect.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  @Input() insect?:IInsect
  @Output() updated:EventEmitter<null>= new EventEmitter();
  constructor(private service:InsectService) { }

  ngOnInit(): void {
  }

  updateInsect(){
    if(this.insect) {
      console.log(this.insect);
      this.service.putInsect(this.insect).subscribe(
      ()=>{
        this.updated.emit();        
      }
    );}

  }


}
