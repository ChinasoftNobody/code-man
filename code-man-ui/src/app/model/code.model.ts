import {BaseModel} from './base.model';
import {UserModel} from './user.model';

export class CodeModel extends BaseModel {
  name?: string;
  description?: string;
  type?: CodeTypeEnum;
  owner?: UserModel;
  url?: string;
}

export class CodeFileModel {
  name?: string;
  updateTime?: number;
  type?: FileTypeEnum;
  children?: CodeFileModel[];
  level?: number;
}

export enum CodeTypeEnum {
  GIT
}

export enum FileTypeEnum {
  FILE,
  DIR
}
