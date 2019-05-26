import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { switchMap, finalize, takeUntil, tap } from 'rxjs/operators';

import { AlunoService } from '../aluno.service';
import { Aluno } from 'src/app/app-common/models/aluno';

@Component({
  selector: 'app-aluno-formulario',
  templateUrl: './aluno-formulario.component.html',
  styleUrls: ['./aluno-formulario.component.css']
})
export class AlunoFormularioComponent implements OnInit, OnDestroy {

  private unsubscribe$ = new Subject<void>();
  private id: number;

  private _aluno$: Observable<Aluno>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private alunoService: AlunoService
  ) { }

  ngOnInit() {
    this._aluno$ = this.route.params.pipe(
      switchMap((params: any) => {
        this.id = <number>params['id'];
        return this.alunoService.getAluno(this.id);
      }),
      tap({
        next: data => {
          console.log('on next:', data);
        },
        error: error => {
          console.log('on error:', error);
          this.router.navigate(['/alunoNaoEncontrado']);
        },
        complete: () => console.log('on complete')
      }),    
      takeUntil(this.unsubscribe$),      
      finalize(() => console.log('params: completed'))
    );
  }

  ngOnDestroy() {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  get aluno$() {
    return this._aluno$;
  }

}
