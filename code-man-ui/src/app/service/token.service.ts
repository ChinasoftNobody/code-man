import {Injectable} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';
import {UserModel} from '../model/user.model';

@Injectable()
export class TokenService {
  public static tokenKey = 'access-token';

  constructor(private cookie: CookieService) {
  }

  isLogin(): boolean {
    return this.cookie.get(TokenService.tokenKey) !== undefined && this.cookie.get(TokenService.tokenKey).length > 0;
  }

  getToken(): string {
    return this.cookie.get(TokenService.tokenKey);
  }

  setToken(tokenStr: string): void {
    this.cookie.set(TokenService.tokenKey, tokenStr, 1);
  }

  clearToken() {
    this.cookie.delete(TokenService.tokenKey);
  }

}
