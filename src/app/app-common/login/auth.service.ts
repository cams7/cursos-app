import { Injectable, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

import { Usuario } from '../models/usuario';

@Injectable()
export class AuthService {

  private _usuarioAutenticado: boolean = false;

  private _mostrarMenuEmitter = new EventEmitter<boolean>();

  constructor(
    private router: Router
  ) { }

  fazerLogin(usuario: Usuario) {
    if (usuario.nome === 'teste@teste.com' &&  usuario.senha === '12345') {
      this._usuarioAutenticado = true;
      this._mostrarMenuEmitter.emit(true);
      this.router.navigate(['/']);
    } else {
      this._usuarioAutenticado = false;
      this._mostrarMenuEmitter.emit(false);
    }
  }

  get usuarioAutenticado() {
    return this._usuarioAutenticado;
  }

  get mostrarMenuEmitter() {
    return this._mostrarMenuEmitter;
  }
}
