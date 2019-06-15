import { Injectable } from '@angular/core';
import { Observable, of, throwError, interval } from 'rxjs';
import { filter, switchMap, take, delay, toArray, find, map, finalize } from 'rxjs/operators';

import { Curso } from '../app-common/models/curso';

@Injectable()
export class CursoService {

  private cursos: Curso[] = [
    { id: 1, nome: 'Curso ' + 1 },
    { id: 2, nome: 'Curso ' + 2 },
    { id: 3, nome: 'Curso ' + 3 },
    { id: 4, nome: 'Curso ' + 4 },
    { id: 5, nome: 'Curso ' + 5 },
    { id: 5, nome: 'Curso ' + 6 },
    { id: 5, nome: 'Curso ' + 7 }
  ]

  private _cursos$: Observable<Curso[]> = of(this.cursos).pipe(  
    finalize(() => console.log('cursos$: completed'))
  );
  
  constructor() { }

  getCurso(id: number): Observable<any> {
    return this.cursos$.pipe(
      switchMap(cursos => cursos),
      find(curso => curso.id == id),
      delay(1000),
      switchMap(curso => {
        if (!curso) 
          return throwError('O aluno (' + id + ') não foi encontrado');        
        return of(curso);
      }),
      finalize(() => console.log('getCurso(' + id + '): completed'))
    );
  }

  get cursos$() {    
    return this._cursos$;
  }  
}
