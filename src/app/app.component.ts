import { Component, OnInit } from '@angular/core';

import { AuthService } from './app-common/login/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private _mostrarMenu: boolean;

  constructor(
    private authService: AuthService
  ) {
  }

  ngOnInit(){
    if(!this.authService.usuarioAutenticado)
      this.authService.mostrarMenuEmitter.subscribe(
        (mostrar: boolean) => this._mostrarMenu = mostrar
      );
  }

  logout() {
    this._mostrarMenu = false;
  }

  get mostrarMenu() {
    return this._mostrarMenu;
  }  
}
