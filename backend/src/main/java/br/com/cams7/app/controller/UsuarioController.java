/**
 * 
 */
package br.com.cams7.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api("Endpoint utilizado para criação, recuperação, atualização e exclusão de usuários.")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation("Lista todos os usuários.")
	@JsonView(View.Public.class)
	@GetMapping
	public List<UsuarioEntity> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@ApiOperation("Busca o usuário pelo ID.")
	@JsonView(View.LoggedIn.class)
	@GetMapping(path = "{id}")
	public ResponseEntity<UsuarioEntity> getUsuarioById(
			@ApiParam("ID do usuário.") @PathVariable(value = "id") Long usuarioId) {
		UsuarioEntity usuario = usuarioService.getUsuarioById(usuarioId);
		return ResponseEntity.ok().body(usuario);
	}

	@ApiOperation("Cadastra um novo usuário.")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UsuarioEntity createUsuario(@ApiParam("Entidade usuário.") @Valid @RequestBody UsuarioEntity usuario) {
		UsuarioEntity savedUsuario = usuarioService.createUsuario(usuario);
		return savedUsuario;
	}

	@ApiOperation("Atualiza o usuário pelo ID.")
	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UsuarioEntity> updateUsuario(
			@ApiParam("ID do usuário.") @PathVariable(value = "id") Long usuarioId,
			@ApiParam("Entidade usuário.") @Valid @RequestBody UsuarioEntity usuario) {
		final UsuarioEntity updatedUsuario = usuarioService.updateUsuario(usuarioId, usuario);
		return ResponseEntity.ok(updatedUsuario);
	}

	@ApiOperation("Remove o usuário pelo ID.")
	@DeleteMapping(path = "{id}")
	public Map<String, Boolean> deleteUsuario(@ApiParam("ID do usuário.") @PathVariable(value = "id") Long usuarioId) {
		usuarioService.deleteUsuario(usuarioId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
