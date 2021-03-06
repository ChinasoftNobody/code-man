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
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './header/header.component';
import {LoginService} from './service/login.service';
import {ProjectService} from './project/project.service';
import {DashboardComponent} from './project/dashboard/dashboard.component';
import {HeaderService} from './service/header.service';
import {CodeComponent} from './project/code/code.component';
import {ProjectComponent} from './project/project.component';
import {CodeService} from './project/code/code.service';
import {FileComponent} from './project/code/file/file.component';
import {CodeItemComponent} from './project/code/item/code-item.component';
import {CrumbsComponent} from './common/crumbs/crumbs.component';
import {MenubarModule} from 'primeng/menubar';
import {ButtonModule} from 'primeng/button';
import {
  ChartModule,
  InputTextModule,
  EditorModule,
  ContextMenuModule,
  DropdownModule,
  OrderListModule,
  BreadcrumbModule, PanelModule, CardModule, TreeTableModule, DialogModule
} from 'primeng/primeng';
import {DataViewModule} from 'primeng/dataview';
import {Db} from './service/db';


@NgModule({
  declarations: [
    AppComponent, LoginComponent, BottomSheetErrorComponent, HeaderComponent,
    DashboardComponent, CodeComponent, ProjectComponent, FileComponent,
    CodeItemComponent, CrumbsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,

    MenubarModule,
    ButtonModule,
    InputTextModule,
    ChartModule,
    EditorModule,
    ContextMenuModule,
    DropdownModule,
    OrderListModule,
    BreadcrumbModule,
    DataViewModule,
    PanelModule,
    CardModule,
    TreeTableModule,
    DialogModule
  ],
  entryComponents: [BottomSheetErrorComponent],
  providers: [LoginInterceptor, TokenService, CookieService, ErrorService, HttpService, LoginService,
    ProjectService, HeaderService, CodeService, Db],
  bootstrap: [AppComponent],
})
export class AppModule {
}
