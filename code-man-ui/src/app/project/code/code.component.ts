import {Component, OnInit} from '@angular/core';
import {PageModel} from '../../model/page.model';
import {ProjectModel} from '../../model/project.model';
import {ProjectService} from '../../service/project.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CodeModel} from '../../model/code.model';
import {CodeService} from '../../service/code.service';
import {HeaderService} from '../../service/header.service';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'app-code',
  templateUrl: './code.component.html',
  styleUrls: ['./code.component.css']
})
export class CodeComponent implements OnInit {
  dialogDisplay = false;
  codes: CodeModel[];
  createCodeModel: CodeModel = {};
  codeSourcesOptions: SelectItem[] = [
    {label: 'GitHub', value: 'GitHub'}, {label: 'SVN', value: 'SVN'}
  ];

  constructor(
    private router: Router,
    private activeRoute: ActivatedRoute,
    private codeService: CodeService) {
  }

  ngOnInit(): void {
    this.activeRoute.parent.paramMap.subscribe(params => {
      this.codeService.queryCodesByProject(params.get('projectId')).subscribe(
        codes => {
          this.codes = codes;
        }
      );
    });


  }

  showCreateCodeDialog() {
    this.dialogDisplay = true;
  }

  createCodeFunc() {
    this.codeService.createCode(this.createCodeModel).subscribe(value => {
      this.codes.push(value);
      this.dialogDisplay = false;
      this.createCodeModel = {};
    });
  }
}

