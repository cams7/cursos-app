/**
 * 
 */
package br.com.cams7.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@JsonView(View.Public.class)
	@GetMapping
	public List<UsuarioEntity> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@JsonView(View.LoggedIn.class)
	@GetMapping("{id}")
	public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable(value = "id") Long usuarioId) {
		UsuarioEntity usuario = usuarioService.getUsuarioById(usuarioId);
		return ResponseEntity.ok().body(usuario);
	}

	@PostMapping
	public UsuarioEntity createUsuario(@Valid @RequestBody UsuarioEntity usuario) {
		UsuarioEntity savedUsuario = usuarioService.createUsuario(usuario);
		return savedUsuario;
	}

	@PutMapping("{id}")
	public ResponseEntity<UsuarioEntity> updateUsuario(@PathVariable(value = "id") Long usuarioId,
			@Valid @RequestBody UsuarioEntity usuario) {
		final UsuarioEntity updatedUsuario = usuarioService.updateUsuario(usuarioId, usuario);
		return ResponseEntity.ok(updatedUsuario);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId) {
		usuarioService.deleteUsuario(usuarioId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
