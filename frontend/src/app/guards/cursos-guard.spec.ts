import { TestBed } from '@angular/core/testing';

import { CursosGuard } from './cursos-guard';

describe('CursosGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CursosGuard = TestBed.get(CursosGuard);
    expect(service).toBeTruthy();
  });
});
