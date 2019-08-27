import {Injectable} from '@angular/core';
import {CodeFileModel, CodeModel, FileTypeEnum} from '../model/code.model';
import {HttpService} from './http.service';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable()
export class CodeService {

  constructor(private http: HttpService) {
  }

  queryCodesByProject(projectId: string): Observable<CodeModel[]> {
    return new BehaviorSubject<CodeModel[]>([{name: 'TestService', description: 'TestService', id: '1'},
      {name: 'TestService2', description: 'TestService2', id: '2'}]);
  }

  queryCodeFileTree(projectId: string, codeId: string, branch: string): Observable<CodeFileModel> {
    if (branch === 'master') {
      return new BehaviorSubject<CodeFileModel>({
        name: 'TestService', type: FileTypeEnum.DIR, updateTime: 152665326, children: [
          {name: 'Main.java', updateTime: 152665329, type: FileTypeEnum.FILE},
          {name: 'ReadMe', type: FileTypeEnum.FILE, updateTime: 152665326}
        ]
      });
    } else {
      return new BehaviorSubject<CodeFileModel>({
        name: 'TestService', type: FileTypeEnum.DIR, updateTime: 152665326, children: [
          {name: 'Main.java', updateTime: 152665329, type: FileTypeEnum.FILE},
          {name: 'Controller.java', updateTime: 152665329, type: FileTypeEnum.FILE},
          {name: 'ReadMe', type: FileTypeEnum.FILE, updateTime: 152665326}
        ]
      });
    }

  }

  queryCodeBranches(projectId: string, codeId: string): Observable<string[]> {
    return new BehaviorSubject<string[]>(['master', 'develop']);
  }
}
