import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { ActivatedRouteSnapshot, RouterStateSnapshot, Resolve, Router } from '@angular/router';

import { AlunoService } from '../aluno.service';
import { Aluno } from 'src/app/app-common/models/aluno';
import { tap } from 'rxjs/operators';

@Injectable()
export class AlunoResolver implements Resolve<Aluno> {

  constructor(
    private router: Router,
    private alunoService: AlunoService
  ) { }

  resolve(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): Aluno | Observable<Aluno> | Promise<Aluno> {         
      let id = route.params['id'];      
      return this.alunoService.getAlunoById(id).pipe(
        tap({
          error: error => {
            this.router.navigate(['/alunoNaoEncontrado']);
          }
        }),
      );
  }
}
