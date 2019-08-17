import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params} from '@angular/router';
import {HeaderService} from '../service/header.service';
import {ProjectModel} from '../model/project.model';
import {ProjectService} from '../service/project.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  project: ProjectModel;

  // 项目代码
  constructor(private activeRoute: ActivatedRoute,
              private headerService: HeaderService,
              private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.project = this.projectService.getProjectList()[0];
    this.activeRoute.params.subscribe((params: Params) => {
      if (params.projectId !== this.project.id) {
        this.project = this.projectService.changeProject(params.projectId);
      }
      this.initProjectInfo();
    });
  }

  private initProjectInfo() {
  }
}
