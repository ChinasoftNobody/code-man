import {Component} from '@angular/core';
import {UserModel} from '../model/user.model';
import {HttpService, IamUrls} from '../service/http.service';
import {ResponseModel} from '../model/response.model';
import {Router} from '@angular/router';
import {ErrorService} from '../service/error.service';
import {TokenService} from '../service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  userInfo: UserModel = new UserModel();

  constructor(private httpService: HttpService, private routes: Router, private error: ErrorService,
              private tokenService: TokenService) {
  }


  login() {
    this.httpService.request<UserModel>(IamUrls.loginUrl, this.userInfo).subscribe(user => {
      this.tokenService.saveUserInfo(user);
      const promise = this.routes.navigate(['/home']);
      promise.catch(reason => {
        this.error.newBusinessError('自动跳转失败：' + reason);
      });
    });
  }
}


