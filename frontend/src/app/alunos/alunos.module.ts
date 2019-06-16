import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AlunosRoutingModule } from './alunos-routing.module';

import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';
import { AlunoFormularioComponent } from './aluno-formulario/aluno-formulario.component';
import { AlunoListagemComponent } from './aluno-listagem/aluno-listagem.component';

import { AlunoService } from './aluno.service';
import { AlunosDeactivateGuard } from './guards/alunos-deactivate-guard';
import { AlunoResolver } from './guards/aluno-resolver';

@NgModule({
  declarations: [
    AlunoDetalheComponent, 
    AlunoFormularioComponent, 
    AlunoListagemComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AlunosRoutingModule
  ], 
  providers: [
    AlunoService,
    AlunosDeactivateGuard,
    AlunoResolver
  ]
})
export class AlunosModule { }
