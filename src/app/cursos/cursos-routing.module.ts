import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CursoListagemComponent } from './curso-listagem/curso-listagem.component';
import { CursoFormularioComponent } from './curso-formulario/curso-formulario.component';
import { CursoDetalheComponent } from './curso-detalhe/curso-detalhe.component';

const routes: Routes = [
  {
    path: '',
    component: CursoListagemComponent
  },
  {
    path: 'novo',
    component: CursoFormularioComponent
  },
  {
    path: ':id/editar',
    component: CursoFormularioComponent
  },
  {
    path: ':id',
    component: CursoDetalheComponent
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CursosRoutingModule { }
