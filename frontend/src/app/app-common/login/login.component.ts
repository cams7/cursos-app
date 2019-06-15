import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';

import { Usuario } from '../models/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private _usuario: Usuario;

  constructor(
    private authService: AuthService
  ) { }

  ngOnInit() {
    this._usuario = {} as Usuario;
  }

  fazerLogin(){
    this.authService.fazerLogin(this._usuario);
  }

  get usuario() {
    return this._usuario;
  }

}
