import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HomeComponent} from './home/home.component';
import {LoginInterceptor} from './service/login-interceptor.service';
import {TokenService} from './service/token.service';
import {CookieService} from 'ngx-cookie-service';
import {LoginComponent} from './login/login.component';
import {BottomSheetErrorComponent} from './common/common-error.component';
import {ErrorService} from './service/error.service';
import {HttpService} from './service/http.service';
import {
  MatBottomSheetModule,
  MatButtonModule, MatCardModule,
  MatCheckboxModule, MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatMenuModule, MatPaginatorModule, MatProgressSpinnerModule,
  MatSelectModule, MatSidenavModule, MatSortModule, MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './header/header.component';
import {LoginService} from './service/login.service';


@NgModule({
  declarations: [
    AppComponent, HomeComponent, LoginComponent, BottomSheetErrorComponent, HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatMenuModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    MatIconModule,
    MatSelectModule,
    MatCardModule,
    MatBottomSheetModule,
    HttpClientModule,
    MatGridListModule,
    MatSidenavModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatPaginatorModule,
    MatTableModule
  ],
  entryComponents: [BottomSheetErrorComponent],
  providers: [LoginInterceptor, TokenService, CookieService, ErrorService, HttpService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
