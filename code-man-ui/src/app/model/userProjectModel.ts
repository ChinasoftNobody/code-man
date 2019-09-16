import {BaseModel} from './base.model';
import {UserModel} from './user.model';

export class ProjectModel {
  name?: string;
}

export enum RoleEnum {
  ADMIN, GUEST, PROJECT_CREATOR
}

export class UserProjectModel extends BaseModel {
  project?: ProjectModel;
  user?: UserModel;
  role?: RoleEnum;
}
