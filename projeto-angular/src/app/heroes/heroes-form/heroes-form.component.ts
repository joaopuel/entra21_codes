import { formatCurrency } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-heroes-form',
  templateUrl: './heroes-form.component.html',
  styleUrls: ['./heroes-form.component.css']
})
export class HeroesFormComponent {

  @Input() visibility!: string; 
  @Output() visibilityChange = new EventEmitter<string>();

  // heroForm =  new FormGroup({
  //   name: new FormControl('', Validators.required),
  //   secretIdentity: new FormControl('')
  // });

  heroForm =  this.fb.group({
    name: ['', Validators.required],
    secretIdentity: ['']
  });

  displayForm = () => {
    this.visibility = "";
    this.visibilityChange.emit(this.visibility);
  }

  constructor(private fb: FormBuilder){

  }

}
