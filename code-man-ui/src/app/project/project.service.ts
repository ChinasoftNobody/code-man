import {Injectable} from '@angular/core';
import {UserProjectModel} from '../model/userProjectModel';
import {HeaderService} from '../service/header.service';
import {CodeManUrls, HttpService} from '../service/http.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  projects: UserProjectModel[];

  constructor(private headerService: HeaderService,
              private http: HttpService) {
  }

  /**
   * 查询项目列表
   */
  getProjectList(): Observable<UserProjectModel[]> {
    return this.http.request<UserProjectModel[]>(CodeManUrls.userProjectsUrl, {});
  }

  changeProject(projectId: string): UserProjectModel {
    for (const item of this.projects) {
      if (item.id === projectId) {
        this.headerService.currentProjectSubject.next(item);
        return item;
      }
    }
  }
}
