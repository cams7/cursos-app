import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlunoListagemComponent } from './aluno-listagem.component';

describe('AlunoListagemComponent', () => {
  let component: AlunoListagemComponent;
  let fixture: ComponentFixture<AlunoListagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlunoListagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlunoListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
