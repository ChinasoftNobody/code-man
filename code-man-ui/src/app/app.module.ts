import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
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
  MatInputModule, MatListModule,
  MatMenuModule, MatPaginatorModule, MatProgressSpinnerModule,
  MatSelectModule, MatSidenavModule, MatSortModule, MatTableModule,
  MatToolbarModule, MatTreeModule
} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './header/header.component';
import {LoginService} from './service/login.service';
import {ProjectService} from './service/project.service';
import {DashboardComponent} from './project/dashboard/dashboard.component';
import {HeaderService} from './service/header.service';
import {CodeComponent} from './project/code/code.component';
import {ProjectComponent} from './project/project.component';
import {CodeService} from './service/code.service';
import {FileComponent} from './project/code/file/file.component';
import {FileLeafComponent} from './project/code/file/leaf/file-leaf.component';
import {CodeItemComponent} from './project/code/item/code-item.component';


@NgModule({
  declarations: [
    AppComponent, LoginComponent, BottomSheetErrorComponent, HeaderComponent,
    DashboardComponent, CodeComponent, ProjectComponent, FileComponent, FileLeafComponent,
    CodeItemComponent
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
    MatTableModule, MatListModule, MatTreeModule
  ],
  entryComponents: [BottomSheetErrorComponent],
  providers: [LoginInterceptor, TokenService, CookieService, ErrorService, HttpService, LoginService,
    ProjectService, HeaderService, CodeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
