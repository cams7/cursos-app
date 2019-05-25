import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoFormularioComponent } from './curso-formulario.component';

describe('CursoFormularioComponent', () => {
  let component: CursoFormularioComponent;
  let fixture: ComponentFixture<CursoFormularioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CursoFormularioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CursoFormularioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
