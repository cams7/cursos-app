/**
 * 
 */
package br.com.cams7.app.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.model.UsuarioEntity;
import br.com.cams7.app.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping(path = "/usuarios", produces = APPLICATION_JSON_UTF8_VALUE)
@Api("Endpoint utilizado para criação, recuperação, atualização e exclusão de usuários.")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation("Lista todos os usuários.")
	@JsonView(View.Public.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping
	public Iterable<UsuarioEntity> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@ApiOperation("Busca o usuário pelo ID.")
	@JsonView(View.LoggedIn.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping(path = "{id}")
	public UsuarioEntity getUsuarioById(@ApiParam("ID do usuário.") @PathVariable(value = "id") Long usuarioId) {
		UsuarioEntity usuario = usuarioService.getUsuarioById(usuarioId);
		return usuario;
	}

	@ApiOperation("Cadastra um novo usuário.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = CREATED)
	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public UsuarioEntity createUsuario(@ApiParam("Entidade usuário.") @Valid @RequestBody UsuarioEntity usuario) {
		UsuarioEntity savedUsuario = usuarioService.createUsuario(usuario);
		return savedUsuario;
	}

	@ApiOperation("Atualiza o usuário pelo ID.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = OK)
	@PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public void updateUsuario(@ApiParam("Entidade usuário.") @Valid @RequestBody UsuarioEntity usuario) {
		usuarioService.updateUsuario(usuario);
	}

	@ApiOperation("Remove o usuário pelo ID.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = OK)
	@DeleteMapping(path = "{id}")
	public void deleteUsuario(@ApiParam("ID do usuário.") @PathVariable(value = "id") Long usuarioId) {
		usuarioService.deleteUsuario(usuarioId);
	}
}
