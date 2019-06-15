import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AlunoListagemComponent } from './aluno-listagem/aluno-listagem.component';
import { AlunoFormularioComponent } from './aluno-formulario/aluno-formulario.component';
import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';

import { AlunosDeactivateGuard } from './guards/alunos-deactivate-guard';
import { AlunoResolver } from './guards/aluno-resolver';

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
        component: AlunoFormularioComponent,
        resolve: { aluno : AlunoResolver },
        canDeactivate: [AlunosDeactivateGuard]
      },
      {
        path: ':id',
        component: AlunoDetalheComponent,
        resolve: { aluno : AlunoResolver }
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
