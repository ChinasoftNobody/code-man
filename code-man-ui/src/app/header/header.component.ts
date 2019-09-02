import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../service/login.service';
import {UserModel} from '../model/user.model';
import {ProjectModel} from '../model/project.model';
import {ProjectService} from '../project/project.service';
import {HeaderService} from '../service/header.service';
import {MenuItem, SelectItem} from 'primeng/api';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userInfo: UserModel;
  projects: ProjectModel[];
  currentProject: string;
  menuItems: MenuItem[];
  projectDropdownOptions: SelectItem[];

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
    this.projects = this.projectService.getProjectList();

    function getProjectDropdownOptions(projects: ProjectModel[]): SelectItem[] {
      const options: SelectItem[] = [];
      projects.forEach(value => {
        options.push({
          label: value.name,
          value: value.id
        });
      });
      return options;
    }

    this.projectDropdownOptions = getProjectDropdownOptions(this.projects);
    this.currentProject = this.projects[0].id;
    this.userInfo = this.loginService.getUserInfo();
    this.menuItems = this.getMenuItemsConfig();
    this.headerService.currentProjectSubject.subscribe(projectModel => {
      if (projectModel) {
        this.currentProject = projectModel.id;
      }
    });
  }

  changeProject() {
    this.go(['/project', this.currentProject]);
  }

  private getMenuItemsConfig(): MenuItem[] {
    return [{
      label: 'CodeMan',
      icon: 'pi pi-fw pi-home'
    }, {
      label: '代码托管',
      items: [{
        label: '源码管理',
        icon: 'pi pi-fw pi-file',
        routerLink: 'project/' + this.currentProject + '/code'
      }
      ]
    }, {
      label: '服务构建'
    }, {
      label: '版本发布'
    }
    ];
  }
}
