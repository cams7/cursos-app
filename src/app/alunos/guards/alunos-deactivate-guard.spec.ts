import { TestBed } from '@angular/core/testing';

import { AlunosDeactivateGuard } from './alunos-deactivate-guard';

describe('AlunosDeactivateGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AlunosDeactivateGuard = TestBed.get(AlunosDeactivateGuard);
    expect(service).toBeTruthy();
  });
});
