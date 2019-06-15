import { TestBed } from '@angular/core/testing';

import { AlunoResolver } from './aluno-resolver';

describe('AlunoResolverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AlunoResolver = TestBed.get(AlunoResolver);
    expect(service).toBeTruthy();
  });
});
