import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AlunoDetalheComponent } from './aluno-detalhe/aluno-detalhe.component';
import { AlunoFormularioComponent } from './aluno-formulario/aluno-formulario.component';
import { AlunoListagemComponent } from './aluno-listagem/aluno-listagem.component';

import { AlunoService } from './aluno.service';
import { AlunosRoutingModule } from './alunos-routing.module';

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
    AlunoService
  ]
})
export class AlunosModule { }
