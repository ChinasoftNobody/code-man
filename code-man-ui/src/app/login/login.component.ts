import {Component} from '@angular/core';
import {UserModel} from '../model/user.model';
import {HttpService, CodeManUrls} from '../service/http.service';
import {ResponseModel} from '../model/response.model';
import {Router} from '@angular/router';
import {ErrorService} from '../service/error.service';
import {TokenService} from '../service/token.service';
import {TokenModel} from '../model/token.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  dialogDisplay = true;
  userInfo: UserModel = new UserModel();

  constructor(private httpService: HttpService, private routes: Router, private error: ErrorService,
              private tokenService: TokenService) {
  }


  login() {
    const param = '?username=maysham&password=maysham&grant_type=password&scope=all&client_id=demoApp&client_secret=demoAppSecret';
    this.httpService.requestBase({
      url: CodeManUrls.loginUrl.url + param,
      method: 'GET'
    }, null).subscribe(token => {
      console.log(token);
      this.tokenService.setToken(token.access_token);
      const promise = this.routes.navigate(['/']);
      promise.catch(reason => {
        this.error.newBusinessError('自动跳转失败：' + reason);
      });
    });
  }
}


