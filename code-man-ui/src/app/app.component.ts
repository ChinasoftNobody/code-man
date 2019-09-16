import {Component, OnInit} from '@angular/core';
import {TokenService} from './service/token.service';

@Component({
  selector: 'app-root',
  templateUrl: `./app.component.html`,
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  login: boolean;

  constructor(private token: TokenService) {
  }

  ngOnInit(): void {
    this.login = this.token.isLogin();
  }
}
