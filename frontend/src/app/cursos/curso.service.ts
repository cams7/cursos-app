import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";

import { Curso } from '../app-common/models/curso';

@Injectable()
export class CursoService {
  
  constructor(
    private http: HttpClient
  ) { }

  getCursoById(cursoId: number): Observable<Curso> {
    return <Observable<Curso>>this.http.get(`http://localhost:8010/cursos-app/cursos/${cursoId}`);
  }

  get allCursos$(): Observable<Curso[]> {    
    return <Observable<Curso[]>>this.http.get('http://localhost:8010/cursos-app/cursos');
  }  
}
