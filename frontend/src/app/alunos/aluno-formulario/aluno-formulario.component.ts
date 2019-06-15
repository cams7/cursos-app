import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';
import { finalize, takeUntil, tap } from 'rxjs/operators';

import { FormCanDeactivate } from 'src/app/app-common/form-can-deactivate';

import { Aluno } from 'src/app/app-common/models/aluno';

@Component({
  selector: 'app-aluno-formulario',
  templateUrl: './aluno-formulario.component.html',
  styleUrls: ['./aluno-formulario.component.css']
})
export class AlunoFormularioComponent implements OnInit, OnDestroy, FormCanDeactivate {
  
  private unsubscribe$ = new Subject<void>();

  private _aluno: Aluno;

  private formMudou: boolean = false;

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

  onInput(){
    this.formMudou = true;
    console.log('mudou');
  }

  podeDesativar(): boolean {
    if (this.formMudou) 
      return confirm('Tem certeza que deseja sair dessa página?');
    
    return true;
  }

  get aluno() {
    return this._aluno;
  }

}
