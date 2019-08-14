import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../service/login.service';
import {UserModel} from '../model/user.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userInfo: UserModel;

  constructor(
    private route: Router,
    private loginService: LoginService
  ) {
  }

  go(url: string) {
    this.route.navigate([url]).then();
  }

  logout() {
    this.loginService.logout();
  }

  ngOnInit(): void {
    this.userInfo = this.loginService.getUserInfo();
  }
}
