export class ResponseModel<R> {
  success?: boolean;
  error?: string;
  result?: R;
}

export enum ErrorType {
  SYSTEM, BUSINESS
}

export class ErrorMsg {
  msg: string;
  type: ErrorType;
}
