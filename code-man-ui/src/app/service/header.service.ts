import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';
import {UserProjectModel} from '../model/userProjectModel';

@Injectable()
export class HeaderService {
  currentProjectSubject: Subject<UserProjectModel> = new Subject();

}
