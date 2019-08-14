import {Injectable} from '@angular/core';
import {HttpService, IamUrls, UrlConfig} from './http.service';
import {TokenService} from './token.service';
import {Route, Router} from '@angular/router';
import {ErrorService} from './error.service';
import {UserModel} from '../model/user.model';

@Injectable()
export class LoginService {

  constructor(private httpService: HttpService,
              private tokenService: TokenService,
              private error: ErrorService,
              private route: Router) {
  }

  /**
   * 登出
   */
  logout() {
    this.httpService.request<string>(IamUrls.logoutUrl, {}).subscribe(res => {
      if (res === 'ok') {
        this.tokenService.clearToken();
        this.route.navigate(['login']).then();
      } else {
        this.error.newBusinessError('登出失败');
      }
    });
  }

  getUserInfo(): UserModel {
    return this.tokenService.getUserInfo();
  }
}
