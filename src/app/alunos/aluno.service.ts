import { Injectable } from '@angular/core';
import { Observable, of, throwError, interval } from 'rxjs';
import { filter, switchMap, take, delay, toArray, find, map, finalize } from 'rxjs/operators';

import { Aluno } from '../app-common/models/aluno';

@Injectable()
export class AlunoService {

  private alunos: Aluno[] = [
    { id: 1, nome: 'Aluno ' + 1, email: 'aluno' + 1 + '@teste.com'},
    { id: 2, nome: 'Aluno ' + 2, email: 'aluno' + 2 + '@teste.com'},
    { id: 3, nome: 'Aluno ' + 3, email: 'aluno' + 3 + '@teste.com'},
    { id: 4, nome: 'Aluno ' + 4, email: 'aluno' + 4 + '@teste.com'},
    { id: 5, nome: 'Aluno ' + 5, email: 'aluno' + 5 + '@teste.com'},
    { id: 6, nome: 'Aluno ' + 6, email: 'aluno' + 6 + '@teste.com'},
    { id: 7, nome: 'Aluno ' + 7, email: 'aluno' + 7 + '@teste.com'},
    { id: 8, nome: 'Aluno ' + 8, email: 'aluno' + 8 + '@teste.com'}
  ]

  private _alunos$: Observable<Aluno[]> = of(this.alunos).pipe(          
    finalize(() => console.log('alunos$: completed'))
  );
  
  constructor() { }

  getAluno(id: number): Observable<any> {
    return this.alunos$.pipe(
      switchMap(alunos => alunos),
      find(aluno => aluno.id == id),
      delay(1000),
      switchMap(aluno => {
        if (!aluno) 
          return throwError('O aluno (' + id + ') não foi encontrado');        
        return of(aluno);
      }),
      finalize(() => console.log('aluno$: completed'))
    );
  }

  get alunos$() {    
    return this._alunos$;
  }
}
