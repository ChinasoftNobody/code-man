import {Component, Input, OnInit} from '@angular/core';
import {CodeModel} from '../../../model/code.model';


@Component({
  selector: 'app-code-item',
  templateUrl: './code-item.component.html',
  styleUrls: ['./code-item.component.css']
})
export class CodeItemComponent implements OnInit {

  @Input()
  item: CodeModel;

  constructor() {
  }

  ngOnInit(): void {
  }
}

