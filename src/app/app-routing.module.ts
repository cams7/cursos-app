import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaNaoEncontradaComponent } from './app-common/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './app-common/login/login.component';

import { AuthGuard } from './guards/auth-guard';
import { CursosGuard } from './guards/cursos-guard';
import { AlunosGuard } from './guards/alunos-guard';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home', 
    loadChildren: './home/home.module#HomeModule'
  },
  {
    path: 'cursos', 
    loadChildren: './cursos/cursos.module#CursosModule',
    canActivate: [AuthGuard],
    canActivateChild: [CursosGuard],
    canLoad: [AuthGuard]
  },
  {
    path: 'alunos', 
    loadChildren: './alunos/alunos.module#AlunosModule',
    canActivate: [AuthGuard],
    canActivateChild: [AlunosGuard],
    canLoad: [AuthGuard]
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PaginaNaoEncontradaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
