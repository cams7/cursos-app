import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";
import { CanActivateChild, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AlunosGuard implements CanActivateChild {
  
  constructor() { }

  canActivateChild(
    childRoute: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
      console.log('AlunosGuard: Guarda de rota filha');
      return of(true);
  }  
}
