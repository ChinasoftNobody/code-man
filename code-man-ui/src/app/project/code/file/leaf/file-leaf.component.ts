import {Component, Input, OnInit} from '@angular/core';
import {CodeFileModel} from '../../../../model/code.model';


@Component({
  selector: 'app-code-file-leaf',
  templateUrl: './file-leaf.component.html',
  styleUrls: ['./file-leaf.component.css']
})
export class FileLeafComponent implements OnInit {

  constructor() {
  }

  @Input()
  file: CodeFileModel;

  ngOnInit(): void {
  }


}



