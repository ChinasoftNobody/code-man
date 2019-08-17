import {Component, OnInit} from '@angular/core';
import {PageModel} from '../model/page.model';
import {ProjectModel} from '../model/project.model';
import {ProjectService} from '../service/project.service';
import {MatTableDataSource} from '@angular/material/table';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  constructor(
    private router: Router) {
  }

  ngOnInit(): void {

  }

  applyFilter(value: string) {

  }

  goProject(projectId: string) {

  }
}

