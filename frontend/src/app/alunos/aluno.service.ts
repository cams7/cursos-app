import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from "@angular/common/http";

import { Aluno } from '../app-common/models/aluno';
import { catchError } from 'rxjs/operators';
import { ValidationConstraints } from '../app-common/validation-constraints';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};
const alunosUrl = 'http://localhost:8010/cursos-app/alunos';
@Injectable()
export class AlunoService {

  
  constructor(
    private http: HttpClient
  ) { }

  getAlunoById(alunoId: number): Observable<Aluno> {
    return <Observable<Aluno>>this.http.get(`${alunosUrl}/${alunoId}`);
  }

  get allAlunos$(): Observable<Aluno[]> {    
    return <Observable<Aluno[]>>this.http.get(alunosUrl);
  }

  updateAluno(alunoId: number, aluno: Aluno): Observable<Aluno> {
    return  <Observable<Aluno>>this.http.put(`${alunosUrl}/${alunoId}`, aluno, httpOptions).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(<ValidationConstraints>error.error);
  };
}
