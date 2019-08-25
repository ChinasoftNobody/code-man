import {Component, OnInit} from '@angular/core';
import {ProjectModel} from '../model/project.model';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {HeaderService} from '../service/header.service';
import {ProjectService} from '../service/project.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit{
  project: ProjectModel;

  // 项目代码
  constructor(private activeRoute: ActivatedRoute,
              private headerService: HeaderService,
              private projectService: ProjectService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.project = this.projectService.getProjectList()[0];
    this.activeRoute.params.subscribe((params: Params) => {
      if (params.projectId) {
        if (params.projectId !== this.project.id) {
          this.project = this.projectService.changeProject(params.projectId);
        }
      } else {
        this.route.navigate(['project', this.project.id]).then();
      }

      this.initProjectInfo();
    });
  }

  private initProjectInfo() {
  }
}
