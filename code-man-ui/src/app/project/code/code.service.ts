import {Injectable} from '@angular/core';
import {CodeFileModel, CodeModel, FileTypeEnum} from '../../model/code.model';
import {HttpService} from '../../service/http.service';
import {BehaviorSubject, Observable} from 'rxjs';
import {Db} from '../../service/db';

@Injectable()
export class CodeService {

  constructor(private http: HttpService,
              private db: Db) {
  }

  queryCodesByProject(projectId: string): Observable<CodeModel[]> {
    return new BehaviorSubject<CodeModel[]>(this.db.getData<CodeModel>('t_code'));
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

  createCode(createCodeModel: CodeModel): Observable<CodeModel> {
    return new BehaviorSubject<CodeModel>(this.db.saveData<CodeModel>('t_code', [createCodeModel])[0]);
  }
}
