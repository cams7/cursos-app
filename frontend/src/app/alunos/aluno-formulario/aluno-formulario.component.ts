import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Subject, Subscription } from 'rxjs';
import { finalize, takeUntil, tap } from 'rxjs/operators';

import { FormCanDeactivate } from 'src/app/app-common/form-can-deactivate';

import { Aluno } from 'src/app/app-common/models/aluno';
import { AlunoService } from '../aluno.service';
import { ValidationConstraints } from 'src/app/app-common/validation-constraints';

@Component({
  selector: 'app-aluno-formulario',
  templateUrl: './aluno-formulario.component.html',
  styleUrls: ['./aluno-formulario.component.css']
})
export class AlunoFormularioComponent implements OnInit, OnDestroy, FormCanDeactivate {

  alunoForm: FormGroup;

  private aluno: Aluno;
  private formularioAlterado: boolean = false;
  private submitted = false;

  private unsubscribe$ = new Subject<void>();

  private error: ValidationConstraints;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private alunoService: AlunoService
  ) { }

  ngOnInit() {
    this.route.data.pipe(
      takeUntil(this.unsubscribe$)
    ).subscribe(
      (info: { aluno: Aluno }) => {
        this.aluno = info.aluno;
        this.alunoForm = this.formBuilder.group({
          nome: this.aluno.nome,
          email: this.aluno.email
        });
      }
    );
    this.alunoForm.valueChanges.pipe(
      takeUntil(this.unsubscribe$)
    ).subscribe(changed => {
      if(changed)
        this.formularioAlterado = true;  
    });
  }

  ngOnDestroy() {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
 
  podeDesativar(): boolean {    
    if (this.formularioAlterado)
      return confirm('Tem certeza que deseja sair dessa página?');

    return true;
  }

  onSubmit(): void {
    this.submitted = true;

    if (this.alunoForm.invalid)
      return;

    this.aluno.nome = this.alunoForm.controls.nome.value;
    this.aluno.email = this.alunoForm.controls.email.value;

    this.alunoService.updateAluno(this.aluno.id, this.aluno).subscribe({
      next: (aluno: Aluno) => {
        this.formularioAlterado = false;
      },
      error: (error: ValidationConstraints) => {
        this.error = error;
      },
      complete: () => {
      }
    });
  }  

  getMessage(fieldName: string): string {
    if(!this.isError(fieldName))
      return null;
    
    return this.error.errors.filter(error => error.field == fieldName).map(error => error.defaultMessage)[0];
  }

  private isError(fieldName: string): boolean {
    if(!this.error)
      return false;
    
    return this.error.errors.some(error => error.field == fieldName);  
  }

  get invalidNome() {
    return (this.submitted && this.isError('nome'));
  }

  get invalidEmail() {
    return (this.submitted && this.isError('email'));
  }

}
