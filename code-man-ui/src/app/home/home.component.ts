import {Component, OnInit} from '@angular/core';
import {PageModel} from '../model/page.model';
import {ProjectModel} from '../model/project.model';
import {ProjectService} from '../service/project.service';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  projectPage: PageModel<ProjectModel>;
  displayedColumns: string[] = ['name'];
  dataSource: MatTableDataSource<ProjectModel>;

  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectPage = this.projectService.getProjectList();
    this.dataSource = new MatTableDataSource(this.projectPage.content);
  }

  applyFilter(value: string) {
    this.dataSource.filter = value.trim().toLowerCase();
  }
}

