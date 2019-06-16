import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanLoad, Route, UrlSegment, UrlTree } from '@angular/router';

import { AuthService } from '../app-common/login/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate, CanLoad {

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }
  
  canActivate(
    route: ActivatedRouteSnapshot, 
    state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    return this.verificarAcesso();
  }

  canLoad(
    route: Route, 
    segments: UrlSegment[]
  ): boolean | Observable<boolean> | Promise<boolean> {
    return this.verificarAcesso();
  }

  private verificarAcesso(){
    if (this.authService.usuarioAutenticado)
      return true;
    
    this.router.navigate(['/login']);

    return false;
  }
}
