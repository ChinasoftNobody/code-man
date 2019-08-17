import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../service/login.service';
import {UserModel} from '../model/user.model';
import {ProjectModel} from '../model/project.model';
import {ProjectService} from '../service/project.service';
import {HeaderService} from '../service/header.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userInfo: UserModel;
  projects: ProjectModel[];
  currentProject: string;

  constructor(
    private route: Router,
    private loginService: LoginService,
    private projectService: ProjectService,
    private headerService: HeaderService
  ) {
  }

  go(commands: any[]) {
    this.route.navigate(commands).then();
  }

  logout() {
    this.loginService.logout();
  }

  ngOnInit(): void {
    this.userInfo = this.loginService.getUserInfo();
    this.projects = this.projectService.getProjectList();
    this.currentProject = this.projects[0].id;
    this.headerService.currentProjectSubject.subscribe(projectModel => {
      if (projectModel) {
        this.currentProject = projectModel.id;
      }
    });
  }

  changeProject() {
    this.go(['/project', this.currentProject]);
  }
}
