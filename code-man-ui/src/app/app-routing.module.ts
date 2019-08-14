import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginInterceptor} from './service/login-interceptor.service';
import {LoginComponent} from './login/login.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home', canActivate: [LoginInterceptor]},
  {path: 'home', component: HomeComponent, canActivate: [LoginInterceptor]},
  {path: 'login', component: LoginComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
