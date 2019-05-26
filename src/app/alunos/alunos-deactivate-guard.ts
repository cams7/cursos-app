import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate, UrlTree } from '@angular/router';

import { FormCanDeactivate } from '../app-common/form-can-deactivate';

@Injectable()
export class AlunosDeactivateGuard implements CanDeactivate<FormCanDeactivate> { 

  constructor() { }

  canDeactivate(
    component: FormCanDeactivate, 
    currentRoute: ActivatedRouteSnapshot, 
    currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
      console.log('guarda de desativação');

      return component.podeDesativar ? component.podeDesativar() : true;
  }
}
