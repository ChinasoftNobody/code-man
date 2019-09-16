import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {TokenService} from './token.service';
import {environment} from '../../environments/environment';

@Injectable()
export class LoginInterceptor implements CanActivate {
  constructor(
    private router: Router,
    private tokenService: TokenService
  ) {
  }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> | boolean | UrlTree {
    // if (!environment.production) {
    //   return true;
    // }
    // 返回值 true: 跳转到当前路由 false: 不跳转到当前路由
    // 当前路由名称
    const isLogin = this.tokenService.isLogin();  // 是否登录
    if (!isLogin) {
      // 未登录，跳转到login
      this.router.navigate(['login']).then();
      return false;
    } else {
      // 已登录，跳转到当前路由
      return true;
    }
  }

}
