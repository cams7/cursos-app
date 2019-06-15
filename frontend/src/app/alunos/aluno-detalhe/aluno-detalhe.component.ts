import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { finalize, takeUntil, tap } from 'rxjs/operators';

import { Aluno } from 'src/app/app-common/models/aluno';

@Component({
  selector: 'app-aluno-detalhe',
  templateUrl: './aluno-detalhe.component.html',
  styleUrls: ['./aluno-detalhe.component.css']
})
export class AlunoDetalheComponent implements OnInit, OnDestroy {

  private unsubscribe$ = new Subject<void>();
  
  private _aluno: Aluno;

  constructor(
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.route.data.pipe(
      takeUntil(this.unsubscribe$),      
      finalize(() => console.log('data: completed'))
    ).subscribe(
      (info: {aluno: Aluno}) => this._aluno = info.aluno
    );
  }

  ngOnDestroy() {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  editarContato(){
    this.router.navigate(['/alunos', this._aluno.id, 'editar']);
  }

  get aluno() {
    return this._aluno;
  }
}
