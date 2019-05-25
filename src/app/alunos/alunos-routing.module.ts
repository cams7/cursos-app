import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AlunoListagemComponent } from './aluno-listagem/aluno-listagem.component';
import { AlunoFormularioComponent } from './aluno-formulario/aluno-formulario.component';
import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';

const routes: Routes = [
  {
    path: '',
    component: AlunoListagemComponent,
    children: [
      {
        path: 'novo',
        component: AlunoFormularioComponent
      },
      {
        path: ':id/editar',
        component: AlunoFormularioComponent
      },
      {
        path: ':id',
        component: AlunoDetalheComponent
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
