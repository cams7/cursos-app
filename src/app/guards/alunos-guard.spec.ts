import { TestBed } from '@angular/core/testing';

import { AlunosGuard } from './alunos-guard';

describe('AlunosGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AlunosGuard = TestBed.get(AlunosGuard);
    expect(service).toBeTruthy();
  });
});
