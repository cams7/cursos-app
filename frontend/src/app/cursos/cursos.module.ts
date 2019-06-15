import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosRoutingModule } from './cursos-routing.module';

import { CursoDetalheComponent } from './curso-detalhe/curso-detalhe.component';
import { CursoFormularioComponent } from './curso-formulario/curso-formulario.component';
import { CursoListagemComponent } from './curso-listagem/curso-listagem.component';

import { CursoService } from './curso.service';

@NgModule({
  declarations: [
    CursoDetalheComponent, 
    CursoFormularioComponent, 
    CursoListagemComponent
  ],
  imports: [
    CommonModule,
    CursosRoutingModule
  ], 
  providers: [
    CursoService
  ]
})
export class CursosModule { }
