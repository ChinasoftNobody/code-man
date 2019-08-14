import {Injectable} from '@angular/core';
import {PageModel} from '../model/page.model';
import {ProjectModel} from '../model/project.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  /**
   * 查询项目列表
   */
  getProjectList(): PageModel<ProjectModel> {
    // todo 查询项目列表
    return {
      content: [{name: 'project1'}, {name: 'project2'}, {name: 'project3'}],
      number: 1,
      size: 10,
      totalElements: 3
    };
  }

}
