import {Injectable} from '@angular/core';
import {HttpService, CodeManUrls} from './http.service';
import {TokenService} from './token.service';
import {Router} from '@angular/router';
import {ErrorService} from './error.service';

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
    this.httpService.request<any>(CodeManUrls.logoutUrl, {}).subscribe(res => {
      if (res === 'ok') {
        this.tokenService.clearToken();
        this.route.navigate(['login']).then();
      } else {
        this.error.newBusinessError('登出失败');
      }
    });
  }
}
