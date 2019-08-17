import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {ProjectModel} from '../model/project.model';

@Injectable()
export class HeaderService {
  currentProjectSubject: Subject<ProjectModel> = new Subject();

}
