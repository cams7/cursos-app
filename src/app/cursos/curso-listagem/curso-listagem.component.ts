import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { switchMap, takeUntil, finalize, tap } from 'rxjs/operators';

import { CursoService } from '../curso.service';
import { Curso } from 'src/app/app-common/models/curso';

@Component({
  selector: 'app-curso-listagem',
  templateUrl: './curso-listagem.component.html',
  styleUrls: ['./curso-listagem.component.css']
})
export class CursoListagemComponent implements OnInit, OnDestroy {
  
  private unsubscribe$ = new Subject<void>();

  private _cursos$: Observable<Curso[]>;
  private _pagina: number = 1;

  constructor(
    private router: Router,
    private route: ActivatedRoute,    
    private cursoService: CursoService
  ) { }

  ngOnInit() {
    this._cursos$ =  this.route.queryParams.pipe(
      switchMap((queryParams: any) => {
        let pagina = queryParams['pagina']; 
        this._pagina = pagina ? pagina : 0;
        return this.cursoService.cursos$;        
      }),
      tap({
        next: data => {
          console.log('on next:', data);
        },
        error: error => {
          console.log('on error:', error);
        },
        complete: () => console.log('on complete')
      }),
      takeUntil(this.unsubscribe$),
      finalize(() => console.log('queryParams: completed'))
    );
  }

  proximaPagina(){
    this.router.navigate(['/cursos'], {queryParams: {'pagina': ++this._pagina}});
  }

  ngOnDestroy() {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }

  get cursos$() {
    return this._cursos$;
  }

  get pagina() {
    return this._pagina;
  }

}
