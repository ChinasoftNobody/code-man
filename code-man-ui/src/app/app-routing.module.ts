import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginInterceptor} from './service/login-interceptor.service';
import {LoginComponent} from './login/login.component';
import {DashboardComponent} from './project/dashboard/dashboard.component';
import {CodeComponent} from './project/code/code.component';
import {ProjectComponent} from './project/project.component';
import {FileComponent} from './project/code/file/file.component';


const routes: Routes = [
  {path: '', component: DashboardComponent, canActivate: [LoginInterceptor]},
  {path: 'login', component: LoginComponent},
  {
    path: 'project/:projectId', component: ProjectComponent, canActivate: [LoginInterceptor], children: [
      {path: '', component: DashboardComponent, canActivate: [LoginInterceptor]},
      {path: 'code', component: CodeComponent, canActivate: [LoginInterceptor]},
      {path: 'code/:codeId/files', component: FileComponent, canActivate: [LoginInterceptor]},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
