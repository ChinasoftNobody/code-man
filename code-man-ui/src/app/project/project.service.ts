import {Injectable} from '@angular/core';
import {ProjectModel} from '../model/project.model';
import {HeaderService} from '../service/header.service';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  projects: ProjectModel[];

  constructor(private headerService: HeaderService) {
  }

  /**
   * 查询项目列表
   */
  getProjectList(): ProjectModel[] {
    // todo 查询项目列表
    this.projects = [{id: '1', name: 'project1'}, {id: '2', name: 'project2'}, {id: '3', name: 'project3'}];
    return this.projects;
  }

  changeProject(projectId: string): ProjectModel {
    for (const item of this.projects) {
      if (item.id === projectId) {
        this.headerService.currentProjectSubject.next(item);
        return item;
      }
    }
  }
}
