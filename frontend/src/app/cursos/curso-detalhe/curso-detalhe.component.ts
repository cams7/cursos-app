import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable, Subject, of } from 'rxjs';
import { switchMap, takeUntil, tap } from 'rxjs/operators';

import { CursoService } from '../curso.service';
import { Curso } from 'src/app/app-common/models/curso';

@Component({
  selector: 'app-curso-detalhe',
  templateUrl: './curso-detalhe.component.html',
  styleUrls: ['./curso-detalhe.component.css']
})
export class CursoDetalheComponent implements OnInit, OnDestroy {

  private unsubscribe$ = new Subject<void>();

  private _curso$: Observable<Curso>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,    
    private cursoService: CursoService
  ) { }

  ngOnInit() {    
    this._curso$ = this.route.params.pipe(
      switchMap((params: any) => {
        let id: number = <number>params['id'];
        return this.cursoService.getCursoById(id);
      }),
      tap({
        error: error => {
          this.router.navigate(['/cursoNaoEncontrado']);
        }
      }),    
      takeUntil(this.unsubscribe$)
    );
  }

  ngOnDestroy() {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  get curso$() {
    return this._curso$;
  }
}
