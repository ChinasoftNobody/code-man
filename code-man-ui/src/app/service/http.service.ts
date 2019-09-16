import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {TokenService} from './token.service';
import {ResponseModel} from '../model/response.model';
import {ErrorService} from './error.service';

export class Urls {
  domain: string;

  getDomain(): string {
    return this.domain;
  }
}

export class UrlConfig {
  constructor(url: string) {
    this.url = url;
    this.method = 'POST';
  }

  url: string;
  method ? = 'POST';
}

export class CodeManUrls extends Urls {
  static domain = 'http://localhost:8080/codeman';
  static loginUrl: UrlConfig = {url: '/oauth/token', method: 'get'};
  static logoutUrl: UrlConfig = {url: '/logout', method: 'get'};
  static userProjectsUrl: UrlConfig = {url: '/api/v1/user/projects', method: 'get'};
}


@Injectable()
export class HttpService {
  constructor(private http: HttpClient, private tokenService: TokenService, private error: ErrorService) {
  }

  /**
   * post 请求返回以json格式封装对象
   * @param urlConfig urlConfig
   * @param requestBody requestBody
   */
  request<T>(urlConfig: UrlConfig, requestBody: any): Observable<T> {
    const url = CodeManUrls.domain + urlConfig.url + '?access_token=' + this.tokenService.getToken();
    const resultSubject: Subject<T> = new Subject();
    this.http.request<ResponseModel<T>>(urlConfig.method, url, {
      body: requestBody,
      observe: 'response',
      headers: {
        authorization: 'Bearer ' + this.tokenService.getToken()
      }
    }).subscribe(res => {
      if (res && res.body && res.status === 200) {
        resultSubject.next(res.body.result);
      } else {
        this.error.newBusinessError(res.body.error);
      }
    }, error1 => {
      this.error.newSystemError(error1);
    });
    return resultSubject;
  }

  /**
   * post 请求返回以json格式封装对象
   * @param urlConfig urlConfig
   * @param requestBody requestBody ''/vjw'yf;;;;;f f `g
   */
  requestBase(urlConfig: UrlConfig, requestBody: any): Observable<any> {
    const url = CodeManUrls.domain + urlConfig.url;
    const resultSubject: Subject<any> = new Subject();
    this.http.request<ResponseModel<any>>(urlConfig.method, url, {
      body: requestBody,
      observe: 'response',
      headers: {
        Authorization: 'Bearer ' + this.tokenService.getToken()
      }
    }).subscribe(res => {
      resultSubject.next(res.body);
    }, error1 => {
      this.error.newSystemError(error1);
    });
    return resultSubject;
  }
}
