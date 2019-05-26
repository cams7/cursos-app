import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AlunosRoutingModule } from './alunos-routing.module';

import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';
import { AlunoFormularioComponent } from './aluno-formulario/aluno-formulario.component';
import { AlunoListagemComponent } from './aluno-listagem/aluno-listagem.component';

import { AlunoService } from './aluno.service';
import { AlunosDeactivateGuard } from './alunos-deactivate-guard';

@NgModule({
  declarations: [
    AlunoDetalheComponent, 
    AlunoFormularioComponent, 
    AlunoListagemComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    AlunosRoutingModule
  ], 
  providers: [
    AlunoService,
    AlunosDeactivateGuard
  ]
})
export class AlunosModule { }
