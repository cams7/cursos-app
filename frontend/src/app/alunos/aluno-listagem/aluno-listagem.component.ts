import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs';

import { AlunoService } from '../aluno.service';
import { Aluno } from 'src/app/app-common/models/aluno';

@Component({
  selector: 'app-aluno-listagem',
  templateUrl: './aluno-listagem.component.html',
  styleUrls: ['./aluno-listagem.component.css']
})
export class AlunoListagemComponent implements OnInit, OnDestroy {

  private _alunos$: Observable<Aluno[]>;

  constructor(
    private alunoService: AlunoService
  ) { }

  ngOnInit() {
    this._alunos$ = this.alunoService.allAlunos$;
  }

  ngOnDestroy() {
  }

  get alunos$() {
    return this._alunos$;
  }

}
