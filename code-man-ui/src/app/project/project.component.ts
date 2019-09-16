import {Component, OnInit} from '@angular/core';
import {UserProjectModel} from '../model/userProjectModel';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {HeaderService} from '../service/header.service';
import {ProjectService} from './project.service';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  project: UserProjectModel;

  // 项目代码
  constructor(private activeRoute: ActivatedRoute,
              private headerService: HeaderService,
              private projectService: ProjectService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.projectService.getProjectList().subscribe(value => {
      this.project = value[0];
    });
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
