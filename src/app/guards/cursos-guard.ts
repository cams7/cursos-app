import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";
import { CanActivateChild, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CursosGuard implements CanActivateChild {

  constructor() { }

  canActivateChild(
    childRoute: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
      console.log('CursosGuard: Guarda de rota filha');
      return of(true);
  }
}
