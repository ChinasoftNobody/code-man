export class UserModel {
  id?: string;
  username?: string;
  password?: string;
  email?: string;
  phone?: string;
  type?: UserType;
  expireTime?: number;
  loginTime?: number;
  loginDomain?: string;
  locked?: boolean;
  logged?: boolean;
  deleted?: boolean;
  createdOn?: number;
  updatedOn?: number;
}

export enum UserType {
  INNER, WEIXIN
}
