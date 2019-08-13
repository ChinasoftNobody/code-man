import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginInterceptor} from './service/login-interceptor.service';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home', canActivate: [LoginInterceptor]},
  {path: 'home', component: HomeComponent, canActivate: [LoginInterceptor]}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
