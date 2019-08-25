import {Component, OnInit} from '@angular/core';
import {PageModel} from '../../model/page.model';
import {ProjectModel} from '../../model/project.model';
import {ProjectService} from '../../service/project.service';
import {MatTableDataSource} from '@angular/material/table';
import {ActivatedRoute, Router} from '@angular/router';
import {CodeModel} from '../../model/code.model';
import {CodeService} from '../../service/code.service';
import {HeaderService} from '../../service/header.service';

@Component({
  selector: 'app-code',
  templateUrl: './code.component.html',
  styleUrls: ['./code.component.css']
})
export class CodeComponent implements OnInit {

  codes: CodeModel[];

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
}

